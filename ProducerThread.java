import java.util.Stack;

public class ProducerThread extends Thread {

	private Stack<IProduct> stack;
	private IProduct product;
	private int stackMaxSize;

	public ProducerThread(Stack<IProduct> stack, int stackMaxSize) {
		super();
		this.stack = stack;
		this.stackMaxSize = stackMaxSize;
	}
	
	@Override
	public void run() {
		while(true) {
	
			synchronized(stack){
				try {
					while(stack.size() == stackMaxSize) {
						System.out.println("Stack is full");
						stack.wait();
					}
				} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				produceProduct();
			}
			
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}


	private synchronized void produceProduct() {
		stack.push(new Product());
		System.out.println("Product produced");
		stack.notify();
		
	}
}

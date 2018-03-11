import java.util.Stack;

public class ProducerThread extends Thread {

	private Stack<IProduct> stack;
	private IProduct newProduct;
	private int stackMaxSize;

	public ProducerThread(Stack<IProduct> stack, int stackMaxSize) {
		super();
		this.stack = stack;
		this.stackMaxSize = stackMaxSize;
	}

	@Override
	public void run() {
		while (true) {
			newProduct = new Product();
			synchronized (stack) {
				while (stack.size() == stackMaxSize) {
					System.out.println("Stack is full");
					try {
						stack.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				pushProduct();
			}
			produce();

			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void pushProduct() {
		stack.push(newProduct);
		stack.notify();
	}

	public void produce() {
		System.out.println("Product produced");
	}
}

import java.util.Stack;

import javax.swing.plaf.multi.MultiTextUI;

public class ConsumerThread extends Thread {

	private Stack stack;
	IProduct product;

	public ConsumerThread(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
	
		while(true) {
			synchronized(stack){
					while(stack.isEmpty()) {
						System.out.println("Stack is empty");
						try {
							stack.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
				
				popProduct();
			}
			consumeProduct();
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	private void popProduct() {
		product = (IProduct) stack.pop();
		stack.notify();
	}

	public void consumeProduct() {
		System.out.println("Product consumed");
	}

		
}

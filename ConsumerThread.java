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
				try {
					while(stack.isEmpty()) {
						System.out.println("Stack is empty");
						stack.wait();
						
					}
				}catch (InterruptedException e) {
						// TODO Auto-generated catch block
						
						e.printStackTrace();
					}
				consumeProduct();
			}
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	private synchronized void consumeProduct() {
		product = (IProduct) stack.pop();
		product.consume();
		stack.notify();
	}
		
}

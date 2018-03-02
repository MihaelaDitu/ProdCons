import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class ApplicationMain {
	
	private static final int STACK_MAX_SIZE = 3;
	private ArrayList<Thread> threadsList = new ArrayList<Thread>();
	private Stack stack = new Stack();
	

	public static void main(String[] args) {
		new ApplicationMain().start();

	}

	private void start() {
		Thread consumer = new ConsumerThread(stack);
		Thread producer = new ProducerThread(stack, STACK_MAX_SIZE);
		
		threadsList.add(producer);
		threadsList.add(consumer);
		startThreads();
		joinThreads();

	}

	private void joinThreads() {
		
		for (Thread thread : threadsList) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void startThreads() {
		
		for (Thread thread : threadsList) {
			thread.start();
		}
		

	}

}

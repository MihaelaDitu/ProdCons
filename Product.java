
public class Product implements IProduct {

	@Override
	public synchronized void consume() {
		System.out.println("Product consumed");
	}

}

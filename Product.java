
public class Product implements IProduct {

	@Override
	public void consume() {
		System.out.println("Product consumed");
	}

	@Override
	public void produce() {
		System.out.println("Product produced");
	}

}

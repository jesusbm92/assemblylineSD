package domain;

public class Main {

	public static void main(String[] args) {

		AssemblyLine al = new AssemblyLine();
		Circle circle = new Circle();
		Rectangle rect = new Rectangle();
		AssemblyStation as1 = new AssemblyStation(circle);
		AssemblyStation as2 = new AssemblyStation(rect);
		Warehouse wh = new Warehouse();
		Product product = new Product();
		product.addComponent(circle);
		product.addComponent(rect);
		product.setAssemblyLine(al);
		as1.setWarehouse(wh);
		as2.setWarehouse(wh);
		al.setNextAssemblyStation(as1);
		al.setNextAssemblyStation(as2);
		Panel p = new Panel(al.getOrder(), product);

	}

}

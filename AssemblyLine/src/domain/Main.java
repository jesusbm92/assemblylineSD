package domain;

public class Main {

	public static void main(String[] args) {

		AssemblyLine al = new AssemblyLine();
		Circle circle = new Circle();
		Rectangle rect = new Rectangle();
		AssemblyStation as1 = new AssemblyStation(circle);
		AssemblyStation as2 = new AssemblyStation(rect);
		AssemblyStation as3 = new AssemblyStation(circle);
		Warehouse wh = new Warehouse();
		as1.setWarehouse(wh);
		as2.setWarehouse(wh);
		as3.setWarehouse(wh);
		
		al.setNextAssemblyStation(as1);
		al.setNextAssemblyStation(as2);
		al.setNextAssemblyStation(as3);
		
		Panel p = new Panel(al);
		p.repaint();

	}

}

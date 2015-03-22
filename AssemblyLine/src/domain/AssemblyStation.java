package domain;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AssemblyStation {
	private Component c1;
	private Warehouse warehouse;

	// private int StockInStation;

	public AssemblyStation(Component c) {
		// TODO Auto-generated constructor stub
		c1 = c;

	}

	public BufferedImage placeComponent(Product p) {
		if (c1.getStock() < 1) {
			warehouse.generateComponents(c1, 1);
		}
		p.addComponent(c1);
		BufferedImage res = c1.draw(20, 20);
		return res;

	}

	public void setWarehouse(Warehouse w) {
		this.warehouse = w;

	}

}

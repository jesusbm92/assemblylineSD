package domain;

import java.util.ArrayList;
import java.util.List;

public class AssemblyStation {
	private Component c1;
	private Warehouse warehouse;
	//private int StockInStation;

	public AssemblyStation(Component c ) {
		// TODO Auto-generated constructor stub
	c1=c;
	
		
	}
	public void placeComponent(Product p){
		if (c1.getStock()<1){
			warehouse.generateComponents(c1, 1);
		}
		p.addComponent(c1);
		
	}
	
	public void setWarehouse (Warehouse w){
		this.warehouse=w;
		
		
	}

}

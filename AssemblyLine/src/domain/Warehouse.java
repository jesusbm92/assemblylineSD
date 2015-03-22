package domain;

public class Warehouse {
	
	public Warehouse() {
		super();
	}
	
	public void generateComponents(Component c, Integer n){
		//Here we must add the number of components n
		c.setStock(n);
	}
	


}

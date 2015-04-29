package domain;

import java.util.List;

public class Warehouse {
	
	private List<AssemblyStation> assemblyStations;

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAssemblyStations(List<AssemblyStation> assemblyStations) {
		this.assemblyStations = assemblyStations;
	}
	
	public void generateComponents(Component c, Integer n){
		//Here we must add the number of components n
		c.setStock(n);
	}
	


}

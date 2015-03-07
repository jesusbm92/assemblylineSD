package domain;

public class Glass implements Command{
	
	private Boolean isPlaced;

	public Glass(Boolean isPlaced) {
		super();
		this.isPlaced = isPlaced;
	}

	public Boolean getIsPlaced() {
		return isPlaced;
	}

	public void setIsPlaced(Boolean isPlaced) {
		this.isPlaced = isPlaced;
	}
	
	@Override
	public void setup(Object AssemblyLineItem) {
		Car c = (Car) AssemblyLineItem;
		for (Glass g: c.getGlasses()){
			g.setIsPlaced(true);
		}
		// To change for graphic application instead of console output
		System.out.println("Glass placed correctly");	
	}

}

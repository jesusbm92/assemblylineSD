package domain;

public class Wheel implements Command{

	private Boolean isPlaced;

	public Wheel(Boolean isPlaced) {
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
		for (Wheel w: c.getWheels()){
			w.setIsPlaced(true);
		}
		// To change for graphic application instead of console output
		System.out.println("Wheel placed correctly");	
	}

}

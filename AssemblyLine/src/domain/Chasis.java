package domain;

public class Chasis implements Command {

	private Boolean isPlaced;

	public Chasis() {
		super();
		this.isPlaced = false;
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
		c.getChasis().setIsPlaced(true);
		// To change for graphic application instead of console output
		System.out.println("Chasis placed correctly");
	}

}

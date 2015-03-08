package domain;

public class Upholstery implements Command {

	private Boolean isPlaced;

	public Upholstery() {
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
		c.getUph().setIsPlaced(true);

		// To change for graphic application instead of console output
		System.out.println("Upholstery placed correctly");
	}
}

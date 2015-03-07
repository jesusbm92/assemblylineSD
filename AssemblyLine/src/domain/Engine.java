package domain;

public class Engine implements Command{
	private Boolean isPlaced;
	
	public Engine() {
		// TODO Auto-generated constructor stub
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
		c.getEngine().setIsPlaced(true);
		// To change for graphic application instead of console output
		System.out.println("Engine placed correctly");
	}

}

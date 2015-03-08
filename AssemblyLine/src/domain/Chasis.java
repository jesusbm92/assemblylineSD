package domain;

public class Chasis extends Component implements Command {

	private String model;

	public Chasis(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void setup(Object AssemblyLineItem) {
		Car c = (Car) AssemblyLineItem;
		c.getChasis().setIsPlaced(true);
		// To change for graphic application instead of console output
		System.out.println("Chasis placed correctly");
	}

}

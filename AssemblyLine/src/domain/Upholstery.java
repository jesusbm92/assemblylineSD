package domain;

public class Upholstery extends Component implements Command {

	public Upholstery() {
		super();
	}

	@Override
	public void setup(Object AssemblyLineItem) {
		Car c = (Car) AssemblyLineItem;
		c.getUph().setIsPlaced(true);

		// To change for graphic application instead of console output
		System.out.println("Upholstery placed correctly");
	}
}

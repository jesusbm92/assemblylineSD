package domain;

public class ElectronicDevice extends Component implements Command {

	private String name;

	public ElectronicDevice(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setup(Object AssemblyLineItem) {
		Car c = (Car) AssemblyLineItem;
		for (ElectronicDevice e : c.getElectronics()) {
			e.setIsPlaced(true);
		}
		// To change for graphic application instead of console output
		System.out.println("ElectronicDevice placed correctly");
	}

}

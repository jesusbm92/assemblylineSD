package domain;

public class Engine extends Component implements Command {

	private String brand;
	private Integer horsepower;

	public Engine(String brand, Integer horsepower) {
		super();
		this.brand = brand;
		this.horsepower = horsepower;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}

	@Override
	public void setup(Object AssemblyLineItem) {
		Car c = (Car) AssemblyLineItem;
		c.getEngine().setIsPlaced(true);
		// To change for graphic application instead of console output
		System.out.println("Engine placed correctly");
	}

}

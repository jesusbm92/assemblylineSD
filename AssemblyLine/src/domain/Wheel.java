package domain;

import java.util.List;
import java.util.ArrayList;

public class Wheel extends Component implements Command {

	// Front left, Front Right, Back Left, Back Right
	private String kindOfWheel;

	public Wheel(String kindOfWheel) {

		super();
		this.kindOfWheel = kindOfWheel;
	}

	public Wheel() {
		super();
	}

	public String getKindOfWheel() {
		return kindOfWheel;
	}

	public void setKindOfWheel(String kindOfWheel) {
		this.kindOfWheel = kindOfWheel;
	}

	@Override
	public void setup(Object AssemblyLineItem) {
		Car c = (Car) AssemblyLineItem;
		List<Wheel> l = new ArrayList<Wheel>();

		l = c.getWheels();

		for (Wheel w : l) {

			w.setIsPlaced(true);

		}

		c.setWheels(l);

		// To change for graphic application instead of console output
		System.out.println("Wheels placed correctly");
	}

}

package domain;

import java.util.ArrayList;
import java.util.List;

public class Sit implements Command {

	private Boolean isPlaced;

	public Sit() {
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
		List<Sit> l = new ArrayList<Sit>();

		l = c.getSits();

		for (Sit s : l) {

			s.setIsPlaced(true);

		}

		c.setSits(l);
		// To change for graphic application instead of console output
		System.out.println("Sits placed correctly");
	}

}

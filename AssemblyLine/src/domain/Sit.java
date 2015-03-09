package domain;

import java.util.ArrayList;
import java.util.List;

public class Sit extends Component implements Command {

	// Front Driver, Co-Driver or back sits
	private String kindOfSit;

	public Sit(String kindOfSit) {
		super();
		this.kindOfSit = kindOfSit;
	}

	public Sit() {
		super();
	}

	public String getKindOfSit() {
		return kindOfSit;
	}

	public void setKindOfSit(String kindOfSit) {
		this.kindOfSit = kindOfSit;
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

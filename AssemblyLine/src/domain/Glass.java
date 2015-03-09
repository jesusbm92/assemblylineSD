package domain;

import java.util.ArrayList;
import java.util.List;

public class Glass extends Component implements Command {

	// This attribute is for reffering to the front glass, back glass or side
	private String kindOfGlass;

	public Glass(String kindOfGlass) {
		super();
		this.kindOfGlass = kindOfGlass;
	}

	public Glass() {
		super();
	}

	public String getKindOfGlass() {
		return kindOfGlass;
	}

	public void setKindOfGlass(String kindOfGlass) {
		this.kindOfGlass = kindOfGlass;
	}

	@Override
	public void setup(Object AssemblyLineItem) {
		Car c = (Car) AssemblyLineItem;
		List<Glass> l = new ArrayList<Glass>();

		l = c.getGlasses();

		for (Glass g : l) {

			g.setIsPlaced(true);

		}

		c.setGlasses(l);
		// To change for graphic application instead of console output
		System.out.println("Glasses placed correctly");
	}

}

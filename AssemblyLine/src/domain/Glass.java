package domain;

import java.util.ArrayList;
import java.util.List;

public class Glass implements Command {

	private Boolean isPlaced;

	public Glass(Boolean isPlaced) {
		super();
		this.isPlaced = isPlaced;
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
		List<Glass> l = new ArrayList<Glass>();

		l = c.getGlasses();

		for (Glass g : l) {

			g.setIsPlaced(true);

		}

		c.setGlasses(l);
		// To change for graphic application instead of console output
		System.out.println("Glass placed correctly");
	}

}

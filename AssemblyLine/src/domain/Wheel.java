package domain;

import java.util.List;
import java.util.ArrayList;

public class Wheel implements Command {
	private Boolean isPlaced;
	public Wheel() {
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
		List<Wheel> l= new ArrayList<Wheel>();
		
		l=c.getWheels();
		for (Wheel whell : l) {
			whell.setIsPlaced(true);
		}
		
		
		// To change for graphic application instead of console output
		System.out.println("Wheels placed correctly");
	}

	
	
}

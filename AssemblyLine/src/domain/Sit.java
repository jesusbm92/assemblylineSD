package domain;

public class Sit implements Command{

	private Boolean isPlaced;

	public Sit(Boolean isPlaced) {
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
		for (Sit s: c.getSits()){
			s.setIsPlaced(true);
		}
		// To change for graphic application instead of console output
		System.out.println("Chasis placed correctly");
		
	}
	

}

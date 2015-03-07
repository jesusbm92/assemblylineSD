package domain;

public class ElectronicDevice implements Command{
	
	private Boolean isPlaced;

	public ElectronicDevice(Boolean isPlaced) {
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
		for (ElectronicDevice e: c.getElectronics()){
			e.setIsPlaced(true);
		}
		// To change for graphic application instead of console output
		System.out.println("ElectronicDevice placed correctly");	
	}

}

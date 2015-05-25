package domain;

import java.awt.image.BufferedImage;

public class SimpleComponent extends Component{
	
	//private EntryComponent entryComponent;
	private Cost cost;

	public SimpleComponent(String string) {
		super(string);
	}

	@Override
	public BufferedImage draw() {
		if (figure == null) {
			return new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
		}
		
		return figure.draw();
	}

	/*public EntryComponent getEntryComponent() {
		return entryComponent;
	}*/

	/*public void setEntryComponent(EntryComponent entryComponent) {
		this.entryComponent = entryComponent;
	}*/
	
	public double getCost() {
		return cost.retrieveAmount();
	}
	
	public void setCost(Cost p) {
		this.cost = p;
	}
	
	/*public Boolean consume() {
		if (entryComponent == null) {
			return false;
		}
		return entryComponent.consume();
	}*/

	
}

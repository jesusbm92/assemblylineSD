package domain;

import java.awt.image.BufferedImage;

public class SimpleComponent extends Component{
	
	private EntryComponent entryComponent;
	private Price price;

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

	public EntryComponent getEntryComponent() {
		return entryComponent;
	}

	public void setEntryComponent(EntryComponent entryComponent) {
		this.entryComponent = entryComponent;
	}
	
	public double getPriceAmount() {
		return price.retrieveAmount();
	}
	
	public void setPrice(Price p) {
		this.price = p;
	}
	
	public Boolean consume() {
		if (entryComponent == null) {
			return false;
		}
		return entryComponent.consume();
	}
	
}

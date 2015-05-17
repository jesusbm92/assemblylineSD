package domain;

import java.awt.image.BufferedImage;

public class SimpleComponent extends Component{
	
	private Figure figure;
	private EntryComponent entryComponent;
	private Price price;

	public SimpleComponent() {
	}
	
	public Figure getFigure() {
		return figure;
	}
	
	public void setFigure(Figure fig) {
		figure = fig;
	}

	@Override
	public BufferedImage draw() {
		if (figure == null) {
			return new BufferedImage(0,0,BufferedImage.TYPE_INT_RGB);
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
	
	
}

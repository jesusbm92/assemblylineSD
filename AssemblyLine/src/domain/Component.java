 package domain;

import java.awt.image.BufferedImage;

abstract class Component{

	protected Figure figure;
	
	public Figure getFigure() {
		return figure;
	}
	
	public void setFigure(Figure fig) {
		figure = fig;
	}
	
	public abstract BufferedImage draw();
	public abstract double getPriceAmount();

}

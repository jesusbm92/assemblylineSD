 package domain;

import java.awt.image.BufferedImage;

abstract class Component{

	protected Figure figure;
	private String name;
	
	public Component() {
		name = "unknown";
	}
	
	public Component(String name) {
		this.name = name;
	}
	
	public Figure getFigure() {
		return figure;
	}
	
	public void setFigure(Figure fig) {
		figure = fig;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract BufferedImage draw();
	public abstract double getPriceAmount();

}

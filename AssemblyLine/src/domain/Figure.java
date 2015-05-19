package domain;

import java.awt.Color;
import java.awt.image.BufferedImage;

abstract class Figure {

	protected Color color;
	protected int width, height;
	
	public Figure(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

	public abstract BufferedImage draw();

}

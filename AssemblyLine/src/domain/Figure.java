package domain;

import java.awt.Color;
import java.awt.image.BufferedImage;

abstract class Figure {

	Color color=Color.GREEN;
	int width=10, height=10;

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

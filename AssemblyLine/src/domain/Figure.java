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

	public abstract BufferedImage draw();

}

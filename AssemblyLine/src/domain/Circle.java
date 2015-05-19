package domain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Circle extends Figure {

	public Circle(int width, int height, Color color) {
		super(width, height, color);
	}

	@Override
	public BufferedImage draw() {
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(color);
        g.fillOval(0, 0, width, height);
		return img;
	}
}

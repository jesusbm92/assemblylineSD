package domain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

public class Triangle extends Figure {

	public Triangle(int width, int height, Color color) {
		super(width, height, color);
	}

	@Override
	public BufferedImage draw() {
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(color);
        g.fillPolygon(new Polygon(new int[]{0, width/2, width}, new int[]{height, 0, height}, 3));
		return img;
	}
}

package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Rectangle extends Figure {


	@Override
	public BufferedImage draw() {
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, width, height);
		return img;
	}

}

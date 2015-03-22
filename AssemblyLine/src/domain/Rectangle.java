package domain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Rectangle extends Component {

	@Override
	public BufferedImage draw(int width, int height) {
		// TODO Auto-generated method stub
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
		return img;
	}

}

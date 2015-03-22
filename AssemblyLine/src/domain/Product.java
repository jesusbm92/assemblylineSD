package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Product implements Drawable {
	
	private List<Component> components;

	public Product() {
		components = new ArrayList<Component>();
	}

	@Override
	public BufferedImage draw(int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics();

		// just draw all components next to each other
		int offset = 0;
		int dimension = Integer.min(width / components.size(), height);
		for (Component c : components) {
			graphics.drawImage(c.draw(dimension, dimension), null,
					offset, 0);
			offset += width / components.size();
		}
		return img;
	}

	public Boolean addComponent(Component c) {
		components.add(c);
		return true; // for later, maybe we want checks to assure the component
						// fits?
	}

}

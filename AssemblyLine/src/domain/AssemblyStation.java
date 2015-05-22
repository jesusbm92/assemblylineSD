package domain;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class AssemblyStation  {
	private SimpleComponent component;
	
	public AssemblyStation(SimpleComponent c) {
		component = c;	
	}
	
	public Boolean placeComponent(ComposedComponent p) {
		return p.add(component);
	}
	
	public BufferedImage draw(int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics();

		FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());	
				
		graphics.drawString(component.getName(), 5, height/3);
		graphics.drawImage(component.draw(/*metrics.getHeight() - 1, metrics.getHeight() - 1*/), null,
				5 + metrics.stringWidth("Component:  "), height/3 - metrics.getHeight() + 1);
		
		return img;
	}

}

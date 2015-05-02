package domain;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class AssemblyStation  {
	private Component component;
	private Warehouse warehouse;
	private Figure F;

	// private int StockInStation;

	public AssemblyStation(Component c) {
		component = c;
		F= new Rectangle();
		
	}
	public void AddComponent(Component c) {
		component = c;
	}
	public Boolean placeComponent(ComposedComponent p) {
		if (component.getStock() < 1) {
			warehouse.generateComponents((SimpleComponent) component, 1);
		}
		p.addComponent(component);
		return true;
	}

	public void setWarehouse(Warehouse w) {
		this.warehouse = w;

	}

	
	public BufferedImage draw(int width, int height) {
		

		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics();

		FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
		
		//graphics.drawRect(0, 0, width - 1, height - 1);
		
		
		graphics.drawImage(F.draw(width - 1, height - 1),null,0,0);
				
				
		graphics.drawString("Component:  ", 5, height/3);
		graphics.drawImage(component.draw(metrics.getHeight() - 1, metrics.getHeight() - 1), null,
				5 + metrics.stringWidth("Component:  "), height/3 - metrics.getHeight() + 1);
		graphics.drawString("Stock:  " + String.valueOf(component.getStock()), 5, height/3 * 2);
		
		return img;
	}

}

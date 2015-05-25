package domain;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AssemblyStation  {
	private SimpleComponent component;
	private Warehouse warehouse;
	
	public AssemblyStation() {
			
	}
	
	public void setComponentType(SimpleComponent c) {
		component = c;	
	}
	
	public Boolean placeComponent(ComposedComponent p) {
		 List<EntryComponent> components=new ArrayList<EntryComponent>();
		 components= warehouse.getAvailableComponents();
		 boolean ComponentExists=false;
		 
		for (EntryComponent entryComponent : components) {
			
			if(entryComponent.getType().equals(component)){
				ComponentExists=entryComponent.consume();
				
			}
			
		}
		if (ComponentExists){
			p.add(component);
			
		}
		
		return ComponentExists;
		
		
	}
	
	public void setWarehouse(Warehouse c) {
		warehouse = c;	
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

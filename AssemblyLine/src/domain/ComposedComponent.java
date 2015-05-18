package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ComposedComponent extends Component {
	 
    //Collection of child components.
    private List<Component> childComponents = new ArrayList<Component>();
 
    //Prints the component.
    public BufferedImage draw() {
    	List<BufferedImage> childImages = new ArrayList<BufferedImage>();
    	int width = 0, height = 0;
    	
        for (Component component : childComponents) {
        	childImages.add(component.draw());
        	width = width + childImages.get(childImages.size()-1).getWidth();
        	height = Math.max(height, childImages.get(childImages.size()-1).getHeight());
        }
        
        if (width == 0 || height == 0) {
        	width = 1; height = 1;
        }
        
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        
        int offsetX = 0;
        for (BufferedImage childImage : childImages) {
        	graphics.drawImage(childImage, null, offsetX, 0);
        	offsetX = offsetX + childImage.getWidth();
        }
        
		return img;
    }

    //Adds the component to the composition.
    public void add(Component component) {
    	childComponents.add(component);
    }
 
    //Removes the component from the composition.
    public void remove(Component component) {
    	childComponents.remove(component);
    }
    
    //retrieve children
    public List<Component> retrieveComponents() {
    	return childComponents;
    }
    
    public double getPriceAmount(){
    	double pr = 0;
    	
    	for (int i=0;i<this.childComponents.size();i++){
    		pr = pr + this.childComponents.get(i).getPriceAmount();	
    	}
    	
    	return pr;
    }
}
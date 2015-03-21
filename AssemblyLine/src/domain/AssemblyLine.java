package domain;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AssemblyLine implements Drawable{
	
	private List<AssemblyStation> orderedStations;
	private List<Product> producedProducts;
	
	public AssemblyLine() {
		orderedStations = new ArrayList<AssemblyStation>();
		
	}
	
	public void setNextAssemblyStation(AssemblyStation station){
		orderedStations.add(station);
	}
	
	public void setProduct(Product p) {
		for (int i=0;i<orderedStations.size();i++){
			orderedStations.get(i).placeComponent(p);
			
		}
		producedProducts.add(p);
		
	}
	
	public int getAssemblyStationCount() {
		return orderedStations.size();
	}
	
	public void advanceSimulationOnStep(int i){
		//orderedStations.get(i).draw();
	}
	
	public Product retrieveFinishedProduct(){
		Product p;
		if (producedProducts.size()==0) {
			p = new Product();
		} else
		{
			p = producedProducts.get(0);
		}

		return p;
		
	}

	@Override
	public BufferedImage draw(int width, int height) {
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		return img;
	}

}

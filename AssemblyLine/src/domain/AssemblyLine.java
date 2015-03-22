package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AssemblyLine implements Drawable {

	private List<AssemblyStation> orderedStations;
	private List<Product> producedProducts;
	
	private int productPosition;
	private Product product;

	public AssemblyLine() {
		orderedStations = new ArrayList<AssemblyStation>();
		producedProducts = new ArrayList<Product>();
	}

	public void setNextAssemblyStation(AssemblyStation station) {
		orderedStations.add(station);
	}

	public void setProduct(Product p) {
		product = p;
		productPosition = -1;
	}

	public int getAssemblyStationCount() {
		return orderedStations.size();
	}

	public void advanceSimulationOneStep() {
		if (product == null)
			return;
		
		productPosition++;
		
		if (productPosition == getAssemblyStationCount()) {
			producedProducts.add(product);
			setProduct(null);
			return;
		}
		
		orderedStations.get(productPosition).placeComponent(product);
	}

	public Product retrieveFinishedProduct() {
		if (producedProducts.size() == 0)
			return null;
		
		return producedProducts.remove(0);
	}


	@Override
	public BufferedImage draw(int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics();
		
		int gridSize = width/(getAssemblyStationCount() + 2);
		
		// draw empty product
		if (product == null)
			graphics.drawString("need new input", 5, height/2 + height/4);
		else
			if (productPosition == -1) 
				graphics.drawString("ready to build", 5, height/2 + height/4);
		
		// draw stations
		for (int stationIndex = 0; stationIndex < getAssemblyStationCount(); stationIndex++) {
			graphics.drawImage(orderedStations.get(stationIndex).draw(gridSize, height/2), null,
					(stationIndex+1) * gridSize, 0);
			
			// draw product
			if ((product != null) && (productPosition == stationIndex)) {
				graphics.drawImage(product.draw(gridSize, height/2), null, 
						(stationIndex+1) * gridSize, height/2);
			}
		}
		
		// draw finished products
		int gridCells = 5;
		for (int productIndex = 0; productIndex < producedProducts.size(); productIndex++) {
			graphics.drawImage(producedProducts.get(productIndex).draw(gridSize/gridCells, gridSize/gridCells), null, 
					gridSize * (getAssemblyStationCount() + 1) + gridSize/gridCells*(productIndex%gridCells), 
					height/2 + gridSize/gridCells * (int)(productIndex/gridCells));
		}
		
		return img;
	}

}

package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AssemblyLine {

	//private List<AssemblyStation> orderedStations;
	private List<Component> producedComponents;
	private ListOfAssemblyStations orderedAssemblyStations;
	
	private int componentPosition;
	private Component component;

	public AssemblyLine() {
		producedComponents = new ArrayList<Component>();
	}
	
	public void setAssemblyStationOrderList(ListOfAssemblyStations stationList){
		orderedAssemblyStations. = stationList;
	}

	/* 2015.05.01 Katrina - Rules do the changes in order of stations
	public void setNextAssemblyStation(AssemblyStation station) {
		orderedStations.add(station);
	}

	public void addAssemblyStation(String name)
	{
		//TODO, designed and used by Rules
		//this.setNextAssemblyStation(new AssemblyStation(Component?));
		//look for the name in the list of component, and create the station
	}
	 2015.05.01 Katrina */
	public void setProduct(Component p) {
		component = p;
		componentPosition = -1;
	}

	public int getAssemblyStationCount() {
		return orderedStations.size();
	}

	public void advanceSimulationOneStep() {
		if (component == null)
			return;
		
		componentPosition++;
		
		if (componentPosition == getAssemblyStationCount()) {
			producedComponents.add(component);
			setProduct(null);
			return;
		}
		
		orderedStations.get(componentPosition).placeComponent(component);
	}

	public Component retrieveFinishedProduct() {
		if (producedComponents.size() == 0)
			return null;
		
		return producedComponents.remove(0);
	}


	public BufferedImage draw(int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics();
		
		int gridSize = width/(getAssemblyStationCount() + 2);
		
		// draw empty product
		if (component == null)
			graphics.drawString("need new input", 5, height/2 + height/4);
		else
			if (componentPosition == -1) 
				graphics.drawString("ready to build", 5, height/2 + height/4);
		
		// draw stations
		for (int stationIndex = 0; stationIndex < getAssemblyStationCount(); stationIndex++) {
			graphics.drawImage(orderedStations.get(stationIndex).draw(gridSize, height/2), null,
					(stationIndex+1) * gridSize, 0);
			
			// draw product
			if ((component != null) && (componentPosition == stationIndex)) {
				graphics.drawImage(component.draw(gridSize, height/2), null, 
						(stationIndex+1) * gridSize, height/2);
			}
		}
		
		// draw finished products
		int gridCells = 5;
		for (int productIndex = 0; productIndex < producedComponents.size(); productIndex++) {
			graphics.drawImage(producedComponents.get(productIndex).draw(gridSize/gridCells, gridSize/gridCells), null, 
					gridSize * (getAssemblyStationCount() + 1) + gridSize/gridCells*(productIndex%gridCells), 
					height/2 + gridSize/gridCells * (int)(productIndex/gridCells));
		}
		
		return img;
	}

}

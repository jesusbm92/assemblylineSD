package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AssemblyLine {

	//private List<AssemblyStation> orderedStations;
	private List<ComposedComponent> finishedWorkpieces;
	private ListOfAssemblyStations orderedAssemblyStations;
	
	private int componentPosition;
	private ComposedComponent workpiece;

	public AssemblyLine() {
		finishedWorkpieces = new ArrayList<ComposedComponent>();
	}
	
	public void setAssemblyStationOrderList(ListOfAssemblyStations stationList){
		//orderedAssemblyStations. = stationList;
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
	public void setWorkpiece(ComposedComponent p) {
		workpiece = p;
		componentPosition = -1;
	}

	public int getAssemblyStationCount() {
		return orderedAssemblyStations.length();
	}

	public void advanceSimulationOneStep() {
		if (workpiece == null)
			return;
		
		componentPosition++;
		
		if (componentPosition == getAssemblyStationCount()) {
			finishedWorkpieces.add(workpiece);
			setWorkpiece(null);
			return;
		}
		
		orderedAssemblyStations.get(componentPosition).placeComponent(workpiece);
	}

	public Component retrieveFinishedProduct() {
		if (finishedWorkpieces.size() == 0)
			return null;
		
		return finishedWorkpieces.remove(0);
	}


	public BufferedImage draw(int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics();
		
		int gridSize = width/(getAssemblyStationCount() + 2);
		
		// draw empty product
		if (workpiece == null)
			graphics.drawString("need new input", 5, height/2 + height/4);
		else
			if (componentPosition == -1) 
				graphics.drawString("ready to build", 5, height/2 + height/4);
		
		// draw stations
		for (int stationIndex = 0; stationIndex < getAssemblyStationCount(); stationIndex++) {
			graphics.drawImage(orderedAssemblyStations.get(stationIndex).draw(gridSize, height/2), null,
					(stationIndex+1) * gridSize, 0);
			
			// draw product
			if ((workpiece != null) && (componentPosition == stationIndex)) {
				graphics.drawImage(workpiece.draw(), null, 
						(stationIndex+1) * gridSize, height/2);
			}
		}
		
		// draw finished products
		int gridCells = 5;
		for (int productIndex = 0; productIndex < orderedAssemblyStations.length(); productIndex++) {
			graphics.drawImage(orderedAssemblyStations.get(productIndex).draw(gridSize/gridCells, gridSize/gridCells), null, 
					gridSize * (getAssemblyStationCount() + 1) + gridSize/gridCells*(productIndex%gridCells), 
					height/2 + gridSize/gridCells * (int)(productIndex/gridCells));
		}
		
		return img;
	}

}

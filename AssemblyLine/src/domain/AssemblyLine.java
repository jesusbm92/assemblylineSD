package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AssemblyLine {

	private List<ComposedComponent> finishedWorkpieces;
	
	private List<AssemblyStation> stations;
	private Rules rules;
	
	private int componentPosition;
	private ComposedComponent workpiece;

	public AssemblyLine(Rules rules) {
		finishedWorkpieces = new ArrayList<ComposedComponent>();
		stations = new ArrayList<AssemblyStation>();
		this.rules = rules;
		
		for (int i=0; i<rules.size(); i++) {
			AssemblyStation station = new AssemblyStation(rules.getRuleAt(i));
			stations.add(station);
		}
		
		
	}
	

	public void setWorkpiece(ComposedComponent p) {
		workpiece = p;
		componentPosition = -1;
	}

	public int getAssemblyStationCount() {
		return stations.size();
	}

	public void advanceSimulationOneStep() {
		if (workpiece == null)
			return;
		
		componentPosition++;
		
		if (componentPosition == getAssemblyStationCount()) {
			rules.checkProduct(workpiece);
			finishedWorkpieces.add(workpiece);
			setWorkpiece(null);
			return;
		}
		
		stations.get(componentPosition).placeComponent(workpiece);
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
			graphics.drawImage(stations.get(stationIndex).draw(gridSize, height/2), null,
					(stationIndex+1) * gridSize, 0);
			
			// draw product
			if ((workpiece != null) && (componentPosition == stationIndex)) {
				graphics.drawImage(workpiece.draw(), null, 
						(stationIndex+1) * gridSize, height/2);
			}
		}
		
		// draw finished products
		int gridCells = 5;
		for (int productIndex = 0; productIndex < finishedWorkpieces.size(); productIndex++) {
			graphics.drawImage(finishedWorkpieces.get(productIndex).draw(), null, 
					gridSize * (getAssemblyStationCount() + 1) + gridSize/gridCells*(productIndex%gridCells), 
					height/2 + gridSize/gridCells * (int)(productIndex/gridCells));
		}
		
		return img;
	}

}

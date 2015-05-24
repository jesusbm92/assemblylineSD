package domain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AssemblyLine {

	private List<ComposedComponent> finishedWorkpieces;
	
	private List<AssemblyStation> stations;
	private Rule rules;
	
	private Warehouse warehouse;
	
	private int componentPosition;
	private ComposedComponent workpiece;

	public AssemblyLine() {
		finishedWorkpieces = new ArrayList<ComposedComponent>();
		stations = new ArrayList<AssemblyStation>();
		
		warehouse = new Warehouse();
		
		List<SimpleComponent> availableComponents = new ArrayList<SimpleComponent>();
		for (EntryComponent entry : warehouse.getAvailableComponents()) {
			availableComponents.add(entry.getType());
		}
		
		RuleDialog rulesDialog = new RuleDialog(null);
		rulesDialog.display(availableComponents);
		
		this.rules = rulesDialog.getRules();
		
		for (int i=0; i<rules.size(); i++) {
			AssemblyStation station = new AssemblyStation(rules.getComponentAt(i));
			stations.add(station);
		}
		
		
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	

	public void setWorkpiece(ComposedComponent p) {
		workpiece = p;
		componentPosition = -1;
	}

	public void advanceSimulationOneStep() {
		if (workpiece == null)
			return;
		
		componentPosition++;
		
		if (componentPosition == stations.size()) {
			rules.checkProduct(workpiece);
			finishedWorkpieces.add(workpiece);
			setWorkpiece(null);
			return;
		}
		
		if (!stations.get(componentPosition).placeComponent(workpiece)) {
			componentPosition--;
			JOptionPane.showMessageDialog(null, "Running low on parts, call your local dealer!");
		}
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
		
		int gridSize = width/(stations.size() + 2);
		
		// draw empty product
		if (workpiece == null)
			graphics.drawString("need new input", 5, height/2 + height/4);
		else
			if (componentPosition == -1) 
				graphics.drawString("ready to build", 5, height/2 + height/4);
			else
				graphics.drawString("Price in moment for processed component is: " + workpiece.getPrice(), 5, height/2 + height/4);
				
		
		// draw stations
		for (int stationIndex = 0; stationIndex < stations.size(); stationIndex++) {
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
					gridSize * (stations.size() + 1) + gridSize/gridCells*(productIndex%gridCells), 
					height/2 + gridSize/gridCells * (int)(productIndex/gridCells));
		}
		
		return img;
	}

}

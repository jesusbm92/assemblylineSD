package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.buttonListeners.NewProductListener;
import domain.buttonListeners.NextStepListener;
import domain.buttonListeners.RetrieveProductListener;

public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4729136638637503204L;
	private static final int HEIGHT = 400;
	private static final int WIDTH = 750;

	private JButton nextStep;
	private JButton newProduct;
	private JButton retrieveProduct;
	private JComboBox<String> stockComponentsBox;
	private JLabel stockLabel;

	private AssemblyLine assemblyLine;
	private Warehouse warehouse;
	
	public Panel() {
		JFrame frame = new JFrame("Assembly Line");
		frame.setSize(WIDTH, HEIGHT);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);
		frame.add(this);

		newProduct = new JButton("New input product");
		newProduct.addActionListener(new NewProductListener(this));
		this.add(newProduct);

		nextStep = new JButton("Place next component");
		nextStep.addActionListener(new NextStepListener(this));
		this.add(nextStep);

		retrieveProduct = new JButton("Retrieve finished product");
		retrieveProduct.addActionListener(new RetrieveProductListener(this));
		this.add(retrieveProduct);

		stockLabel = new JLabel("Stock: ");
		stockLabel.setVisible(true);
		stockLabel.setForeground(Color.WHITE);
		this.add(stockLabel);
		
		stockComponentsBox = new JComboBox<String>();
		this.add(stockComponentsBox);

		// to come: a dialog to populate the warehouse
		// for now its just hardcoded
		warehouse = new Warehouse();
		warehouse.populateWarehouse();
		
		for (EntryComponent component : warehouse.getAvailableComponents()) {
			stockComponentsBox.addItem(component.getType().getName() + " - " + component.getStock());
		}
		
		List<SimpleComponent> availableComponents = new ArrayList<SimpleComponent>();
		for (EntryComponent entry : warehouse.getAvailableComponents()) {
			availableComponents.add(entry.getType());
		}
		
		assemblyLine = new AssemblyLine(availableComponents);

		frame.setVisible(true);
	}

	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		((java.awt.Graphics2D) g).drawImage(
				assemblyLine.draw(this.getWidth(), 200), null, 0, 100);
		
		stockComponentsBox.removeAllItems();
		for (EntryComponent component : warehouse.getAvailableComponents()) {
			stockComponentsBox.addItem(component.getType().getName() + " - " + component.getStock());
		}
	}

	public AssemblyLine getAssemblyLine() {
		return assemblyLine;
	}
	
	

}

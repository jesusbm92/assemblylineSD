package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.buttonListeners.AddRuleListener;
import domain.buttonListeners.NewProductListener;
import domain.buttonListeners.NextStepListener;
import domain.buttonListeners.RemoveRuleListener;
import domain.buttonListeners.RetrieveProductListener;

public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4729136638637503204L;
	private static final int HEIGHT = 400;
	private static final int WIDTH = 700;

	private JButton nextStep;
	private JButton newProduct;
	private JButton retrieveProduct;
	private JComboBox<String> availableComponentsBox;
	private JComboBox<String> stockComponentsBox;
	private JButton addRule;
	private JButton removeRule;
	private JTextField removeRuleInput;
	private JLabel stockLabel;


	private AssemblyLine assemblyLine;
	private Rules rules;
    private List<SimpleComponent> availableComponents;
    private List<EntryComponent> stockComponents;
	
	
	public Panel() {

		rules = new Rules();

		availableComponents = new ArrayList<SimpleComponent>();
		stockComponents = new ArrayList<EntryComponent>();

		Circle circle = new Circle(10, 10, Color.GREEN);
		Rectangle rect = new Rectangle(10, 10, Color.RED);
		Triangle triangle = new Triangle(10, 10, Color.BLUE);
		
		SimpleComponent wheel = new SimpleComponent("wheel");
		SimpleComponent engine = new SimpleComponent("engine");
		SimpleComponent window = new SimpleComponent("window");
		
		EntryComponent wheelEntry = new EntryComponent(wheel);
		wheelEntry.requestStock(5);
		wheel.setEntryComponent(wheelEntry);
		EntryComponent engineEntry = new EntryComponent(engine);
		engineEntry.requestStock(5);
		engine.setEntryComponent(engineEntry);
		EntryComponent windowEntry = new EntryComponent(window);
		windowEntry.requestStock(5);
		window.setEntryComponent(windowEntry);

		wheel.setFigure(circle);
		engine.setFigure(rect);
		window.setFigure(triangle);
		
		availableComponents.add(wheel);
		availableComponents.add(engine);
		availableComponents.add(window);

		stockComponents.add(wheelEntry);
		stockComponents.add(engineEntry);
		stockComponents.add(windowEntry);
		
		//hardcoded price but should be changed
		wheel.setPrice(new Price(5.2));
		engine.setPrice(new Price(100));
		window.setPrice(new Price(45));
		//hardcoded price but should be changed

		assemblyLine = new AssemblyLine(rules);

		JFrame frame = new JFrame("Assembly Line");
		frame.setSize(WIDTH, HEIGHT);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		frame.add(this);

		newProduct = new JButton("New input product");
		newProduct.addActionListener(new NewProductListener(this));
		newProduct.setVisible(true);
		this.add(newProduct);

		nextStep = new JButton("Place next component");
		nextStep.addActionListener(new NextStepListener(this));
		nextStep.setVisible(true);
		this.add(nextStep);

		retrieveProduct = new JButton("Retrieve finished product");
		retrieveProduct.addActionListener(new RetrieveProductListener(this));
		retrieveProduct.setVisible(true);
		this.add(retrieveProduct);

		availableComponentsBox = new JComboBox<String>();
		for (SimpleComponent component : availableComponents) {
			availableComponentsBox.addItem(component.getName());
		}
		availableComponentsBox.setVisible(true);
		this.add(availableComponentsBox);

		addRule = new JButton("Add");
		addRule.addActionListener(new AddRuleListener(this));
		addRule.setVisible(true);
		this.add(addRule);

		removeRule = new JButton("Remove");
		removeRule.addActionListener(new RemoveRuleListener(this));
		removeRule.setVisible(true);
		this.add(removeRule);
		
		removeRuleInput = new JTextField("mm");
		removeRuleInput.setPreferredSize(removeRuleInput.getPreferredSize());
		removeRuleInput.setText("0");
		removeRuleInput.setVisible(true);
		this.add(removeRuleInput);
		
		stockLabel = new JLabel("Stock: ");
		stockLabel.setVisible(true);
		stockLabel.setForeground(Color.WHITE);
		this.add(stockLabel);
		
		stockComponentsBox = new JComboBox<String>();
		for (EntryComponent component : stockComponents) {
			stockComponentsBox.addItem(component.getType().getName() + " - " + component.getStock());
		}
		stockComponentsBox.setVisible(true);
		this.add(stockComponentsBox);

		frame.setVisible(true);
	}

	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		((java.awt.Graphics2D) g).drawImage(
				assemblyLine.draw(this.getWidth(), 200), null, 0, 100);
		
		stockComponentsBox.removeAllItems();
		for (EntryComponent component : stockComponents) {
			stockComponentsBox.addItem(component.getType().getName() + " - " + component.getStock());
		}
	}

	public AssemblyLine getAssemblyLine() {
		return assemblyLine;
	}
	
	public void reloadAssemblyLine() {
		assemblyLine = new AssemblyLine(rules);
	}
	
	public Rules getRules() {
		return rules;
	}
	
	public int getToRemoveRuleIndex() {
		return Integer.parseInt(removeRuleInput.getText());
	}
	
	public SimpleComponent getRuleToAdd() {
		String componentName = availableComponentsBox.getSelectedItem().toString();
		
		for (SimpleComponent component : availableComponents) {
			if (component.getName() == componentName) {
				return component;
			}
		}
		
		return new SimpleComponent("invalid component");
	}

}

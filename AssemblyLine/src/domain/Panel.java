package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JComboBox<String> availableComponents;
	private JButton addRule;
	private JButton removeRule;
	private JTextField removeRuleInput;


	private AssemblyLine assemblyLine;
	Rules rules;
	Circle circle;
	Warehouse wh;
	SimpleComponent wheel;
	SimpleComponent engine;
	Panel p;
	
	//hardcoded price but should be changed
	Price prWheel;
	Price prEngine;
	//hardcoded price but should be changed
	
	public Panel() {

		rules = new Rules();
		wh = new Warehouse();
		p = this;

		circle = new Circle();
		circle.setColor(Color.GREEN);
		Rectangle rect = new Rectangle();
		rect.setColor(Color.RED);
		
		wheel = new SimpleComponent();
		engine = new SimpleComponent();

		wheel.setFigure(circle);
		engine.setFigure(rect);
		
		//hardcoded price but should be changed
		
		prWheel = new Price();
		prWheel.setPrice(5.2);
		wheel.setPrice(prWheel);
		
		prEngine = new Price();
		prEngine.setPrice(100);
		engine.setPrice(prEngine);
		
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

		availableComponents = new JComboBox<String>();
		availableComponents.addItem("wheel");
		availableComponents.addItem("engine");
		availableComponents.setVisible(true);
		this.add(availableComponents);

		addRule = new JButton("Add");
		addRule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (availableComponents.getSelectedItem().toString()) {
				case "wheel":
					rules.addRule(wheel);
					assemblyLine = new AssemblyLine(rules);
					p.repaint();
					break;
				case "engine":
					rules.addRule(engine);
					assemblyLine = new AssemblyLine(rules);
					p.repaint();
				}
			}
		});
		addRule.setVisible(true);
		this.add(addRule);

		removeRule = new JButton("Remove");
		removeRule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(removeRuleInput.getText());
				if (index >=0 && index < rules.size()) {
					rules.removeRuleAt(index);
					assemblyLine = new AssemblyLine(rules);
					p.repaint();
				}
			}
		});
		removeRule.setVisible(true);
		this.add(removeRule);
		
		removeRuleInput = new JTextField("mm");
		removeRuleInput.setPreferredSize(removeRuleInput.getPreferredSize());
		removeRuleInput.setText("0");
		removeRuleInput.setVisible(true);
		this.add(removeRuleInput);

		frame.setVisible(true);
	}

	public void paintComponent(Graphics g, BufferedImage input) {
		JLabel picLabel = new JLabel(new ImageIcon(input));
		add(picLabel);
		this.updateUI();

	}

	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		((java.awt.Graphics2D) g).drawImage(
				assemblyLine.draw(this.getWidth(), 200), null, 0, 100);
	}

	public AssemblyLine getAssemblyLine() {
		return assemblyLine;
	}
	
	public Rules getRules() {
		return rules;
	}

}

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
	private JComboBox<String> simpleComponent;
	private JButton addSimpleComponent;

	private AssemblyLine assemblyLine;
	Rules rules;
	Circle circle;
	Warehouse wh;
	SimpleComponent wheel;
	SimpleComponent engine;
	Panel p;

	public Panel() {

		rules = new Rules();
		wh = new Warehouse();
		p = this;

		circle = new Circle();
		Rectangle rect = new Rectangle();
		rect.setColor(Color.RED);

		wheel = new SimpleComponent(wh);
		engine = new SimpleComponent(wh);

		wheel.setFigure(circle);
		engine.setFigure(rect);

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

		simpleComponent = new JComboBox<String>();
		simpleComponent.addItem("wheel");
		simpleComponent.addItem("engine");
		simpleComponent.setVisible(true);
		this.add(simpleComponent);

		addSimpleComponent = new JButton("Add");
		addSimpleComponent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (simpleComponent.getSelectedItem().toString()) {
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
		addSimpleComponent.setVisible(true);
		this.add(addSimpleComponent);

		addSimpleComponent = new JButton("Remove");
		addSimpleComponent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (simpleComponent.getSelectedItem().toString()) {
				case "wheel":
					rules.removeRule(wheel);
					assemblyLine = new AssemblyLine(rules);
					p.repaint();
					break;
				case "engine":
					rules.removeRule(engine);
					assemblyLine = new AssemblyLine(rules);
					p.repaint();
				}
			}
		});
		addSimpleComponent.setVisible(true);
		this.add(addSimpleComponent);

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

}

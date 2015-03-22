package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4729136638637503204L;
	private static final int HEIGHT = 400;
	private static final int WIDTH = 700;

	private JButton nextStep;
	private JButton newProduct;
	private JButton retrieveProduct;
	
	private AssemblyLine assemblyLine;

	public Panel(AssemblyLine al) {
		
		assemblyLine = al;

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
        ((java.awt.Graphics2D) g).drawImage(assemblyLine.draw(this.getWidth(), 200), null, 0, 100);
    }

	public AssemblyLine getAssemblyLine() {
		return assemblyLine;
	}
	

}

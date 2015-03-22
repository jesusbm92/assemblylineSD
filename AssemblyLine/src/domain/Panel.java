package domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

	private NextStepButtonHandler nextStepButtonHandler;

	public Panel(List<AssemblyStation> order, Product p) {

		JFrame frame = new JFrame("Assembly Line");
		frame.setSize(WIDTH, HEIGHT);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);
		frame.add(this);
		this.setVisible(true);

		nextStep = new JButton("Place next component");
		nextStepButtonHandler = new NextStepButtonHandler(order, p, this);
		nextStep.addActionListener(nextStepButtonHandler);
		nextStep.setVisible(true);

		this.add(nextStep);

	}

	public void paintComponent(Graphics g, BufferedImage input) {
		JLabel picLabel = new JLabel(new ImageIcon(input));
		add(picLabel);
		this.updateUI();

	}

}

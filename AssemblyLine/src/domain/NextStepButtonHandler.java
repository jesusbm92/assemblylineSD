package domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;

public class NextStepButtonHandler implements ActionListener {

	private List<AssemblyStation> order;
	private Product p;
	private Panel panel;

	public NextStepButtonHandler(List<AssemblyStation> order, Product p,
			Panel panel) {
		super();
		this.p = p;
		this.order = order;
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!order.isEmpty()) {
			AssemblyStation next = order.remove(0);
			BufferedImage nextdraw = next.placeComponent(p);
			panel.paintComponent(nextdraw.getGraphics(), nextdraw);
		}
	}
}
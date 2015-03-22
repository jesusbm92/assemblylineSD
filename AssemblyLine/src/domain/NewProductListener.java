package domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProductListener implements ActionListener {

	private Panel panel;
	
	public NewProductListener(Panel p) {
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.getAssemblyLine().setProduct(new Product());
		panel.repaint();
	}

}

package domain.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Panel;

public class RetrieveProductListener implements ActionListener {

	private Panel panel;
	
	public RetrieveProductListener(Panel p) {
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.getAssemblyLine().retrieveFinishedProduct();
		panel.repaint();
	}

}

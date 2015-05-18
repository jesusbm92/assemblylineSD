package domain.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.ComposedComponent;
import domain.Panel;

public class NewProductListener implements ActionListener {

	private Panel panel;
	
	public NewProductListener(Panel p) {
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.getAssemblyLine().setWorkpiece(new ComposedComponent());
		panel.repaint();
	}

}

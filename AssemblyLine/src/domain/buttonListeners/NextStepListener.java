package domain.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Panel;

public class NextStepListener implements ActionListener {

	private Panel panel;
	
	public NextStepListener(Panel p) {
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.getAssemblyLine().advanceSimulationOneStep();
		panel.repaint();
	}

}

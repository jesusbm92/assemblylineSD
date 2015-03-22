package domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

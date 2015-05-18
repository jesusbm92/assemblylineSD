package domain.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Panel;

public class AddRuleListener implements ActionListener {

	private Panel panel;
	
	public AddRuleListener(Panel p) {
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.getRules().addRule(panel.getRuleToAdd());
		panel.reloadAssemblyLine();
		panel.repaint();
	}

}

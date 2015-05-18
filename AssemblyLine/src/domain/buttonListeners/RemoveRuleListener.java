package domain.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Panel;

public class RemoveRuleListener implements ActionListener {

	private Panel panel;
	
	public RemoveRuleListener(Panel p) {
		panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = panel.getToRemoveRuleIndex();
		if (index >=0 && index < panel.getRules().size()) {
			panel.getRules().removeRuleAt(index);
			panel.reloadAssemblyLine();
			panel.repaint();
		}
	}

}

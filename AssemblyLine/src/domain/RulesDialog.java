package domain;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class RulesDialog {

	private JFrame parent;
    private JDialog dialog;
    private Rules rules;
    
//    List<SimpleComponent> availableComponents;
//    JComboBox<String> availableComponentsBox;
    
	public RulesDialog(JFrame owner) {
		this.parent = owner;
	}
	
	private JPanel createPanel(final List<SimpleComponent> availableComponents)
    {
        JPanel panel = new JPanel();
        rules = new Rules();

        JLabel dialogtitlelabel = new JLabel ("Add stations to simulate");
        panel.add (dialogtitlelabel);

        final JTextArea informationtxt = new JTextArea ();
        
        final JComboBox<String> availableComponentsBox = new JComboBox<String>();
		for (SimpleComponent component : availableComponents) {
			availableComponentsBox.addItem(component.getName());
		}
		panel.add(availableComponentsBox);

		JButton addRule = new JButton("Add");
		panel.add(addRule);
		addRule.addActionListener(new ActionListener ()
        {
            @Override public void actionPerformed (ActionEvent a)
            {
                rules.addComponent(availableComponents.get(availableComponentsBox.getSelectedIndex()));
                updateTextAreaWithRules(informationtxt, rules);
            }
        });

		JButton removeRule = new JButton("Remove");
		panel.add(removeRule);

		final JTextField removeRuleInput = new JTextField("mm");
		removeRuleInput.setPreferredSize(removeRuleInput.getPreferredSize());
		removeRuleInput.setText("0");
		
		
		removeRule.addActionListener(new ActionListener ()
        {
            @Override public void actionPerformed (ActionEvent a)
            {
            	if (availableComponentsBox.getSelectedIndex() > rules.size()) {
            		return;
            	}
            	System.out.println();
                rules.removeComponentAt(Integer.parseInt(removeRuleInput.getText()));
                updateTextAreaWithRules(informationtxt, rules);
            }

        });
		
		panel.add(removeRuleInput);


        JScrollPane jsp = new JScrollPane (informationtxt);
        jsp.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setPreferredSize (new Dimension (180, 120));
        panel.add (jsp);

        JButton btnok = new JButton ("OK");
        panel.add (btnok);

        btnok.addActionListener(new ActionListener ()
        {
            @Override public void actionPerformed (ActionEvent a)
            {
                if (rules.size() == 0)
                {
                	JOptionPane.showMessageDialog(dialog, "Add at least one Station to continue.");
                    return;
                }

                //information = informationtxt.getText ();

                dialog.dispose ();
            }
        });

        return panel;
    }

	public void display(List<SimpleComponent> availableComponents) {
		final int DWIDTH = 200;
        final int DHEIGHT = 280;

        dialog = new JDialog (parent, "Define your assembly-rules", true);
        dialog.setSize (DWIDTH, DHEIGHT);
        dialog.setResizable (false);
        dialog.setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);

        dialog.setContentPane(createPanel(availableComponents));

        dialog.setLocationRelativeTo (parent);
        dialog.setVisible (true);
	}
	
	private void updateTextAreaWithRules(JTextArea informationtxt,
			Rules rules) {
		String content = "";
		for (int i=0; i<rules.size(); i++) {
			content += i + " - " + rules.getComponentAt(i).getName() + "\n";
		}
		informationtxt.setText(content);
	}
	
	public Rules getRules() {
		return rules;
	}

}
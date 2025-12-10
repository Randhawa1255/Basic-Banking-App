package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.Logic;
import project.GUI.Closeacc;

public class DeleteaccListener implements ActionListener {
	Logic lo = new Logic();
	private Closeacc ca;

	public DeleteaccListener(Closeacc ca) {
		this.ca = ca;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!ca.accnogetter().isBlank()) {
			lo.delacc(ca.accnogetter());
			if (lo.boolgetter()) {
				JOptionPane.showMessageDialog(ca, "Account No: " + ca.accnogetter() + " has been deleted.");
				lo.boolsetter(false);
			} else {
				JOptionPane.showMessageDialog(ca, "Account Number " + ca.accnogetter() + " not avaliable");
			}
		} else {
			JOptionPane.showMessageDialog(ca, "The field is Empty \n Enter Account Number.");
		}
	}

}

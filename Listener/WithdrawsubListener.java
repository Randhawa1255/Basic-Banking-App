package project.Listener;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.Logic;
import project.GUI.Withdraw;

public class WithdrawsubListener implements ActionListener {
	Logic lo = new Logic();
	private Withdraw wd;

	public WithdrawsubListener(Withdraw wd) {
		this.wd = wd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double amount;
		try {
			amount = Double.parseDouble(wd.valgetter());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(wd, "Invalid amount: " + wd.valgetter());
			return;
		}
		if (amount > 0) {
			if (Double.parseDouble(wd.valgetter()) <= wd.balgetter()) {
				String total = Double.toString(wd.balgetter() - Double.parseDouble(wd.valgetter()));
				lo.balchange(wd.accnogetter(), total);
				wd.disn1(total);
			} else {
				JOptionPane.showMessageDialog(wd, "you don't have sufficent balance ");
			}
		} else {
				JOptionPane.showMessageDialog(wd, "Can't withdraw a negative amount or Zero: " + wd.valgetter());
			}
	}
}

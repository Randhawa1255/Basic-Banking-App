package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.Logic;
import project.GUI.Deposit;

public class DepositaddListener implements ActionListener{
	Logic lo = new Logic();
	private Deposit dp;
	public DepositaddListener(Deposit dp) {
		this.dp = dp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		double amount;
		try {
			amount = Double.parseDouble(dp.valgetter());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(dp, "Invalid amount: " + dp.valgetter());
			return;
		}
		if (amount > 0) {
			String total = Double.toString(dp.balgetter()+Double.parseDouble(dp.valgetter()));
			lo.balchange(dp.accnogetter(), total);
			dp.disn1(total);
			}	
		else {
			JOptionPane.showMessageDialog(dp, "Can't deposit a negative amount or Zero: " + dp.valgetter());
			}
	}
}



package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.Logic;
import project.GUI.Deposit;

public class DepositListener implements ActionListener {
    private Logic lo = new Logic();
    private Deposit dp;

    public DepositListener(Deposit dp) {
        this.dp = dp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acc = dp.accnogetter().trim();
        if (acc.isEmpty()) {
            JOptionPane.showMessageDialog(dp, "Please enter an account number.");
            return;
        }

        String[] data = lo.readdata(acc); // [name, balance] or null

        if (data == null) {
            JOptionPane.showMessageDialog(dp, "Account not found.");
        } else {
            dp.disn(data[0]);
            dp.disn1(data[1]);
            // dp.(data[1]);
        }
    }
}

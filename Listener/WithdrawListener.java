package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.Logic;
import project.GUI.Withdraw;

public class WithdrawListener implements ActionListener {
    private Logic lo = new Logic();
    private Withdraw wd;

    public WithdrawListener(Withdraw wd) {
        this.wd = wd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acc = wd.accnogetter().trim();
        if (acc.isEmpty()) {
            JOptionPane.showMessageDialog(wd, "Please enter an account number.");
            return;
        }

        String[] data = lo.readdata(acc); // [name, balance] or null

        if (data == null) {
            JOptionPane.showMessageDialog(wd, "Account not found.");
        } else {
            wd.disn(data[0]);
            wd.disn1(data[1]);
            //
        }
    }
}

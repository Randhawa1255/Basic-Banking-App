package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.GUI.Closeacc;
import project.GUI.Createacc;
import project.GUI.Deposit;
import project.GUI.Find;
import project.GUI.Withdraw;
import project.GUI.homep;

public class CancelListener implements ActionListener {

	private Createacc ca;
	private Deposit dp;
	private Withdraw wd;
	private Find fd;
	private Closeacc Cla;
	homep hp = new homep();

	public CancelListener(Createacc ca) {
		this.ca = ca;
	}

	public CancelListener(Deposit dp) {
		this.dp = dp;
	}

	public CancelListener(Withdraw wd) {
		this.wd = wd;
	}

	public CancelListener(Find fd) {
		this.fd = fd;
	}

	public CancelListener(Closeacc Cla) {
		this.Cla = Cla;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ca != null) {
			ca.dispose();
		} else if (dp != null) {
			dp.dispose();
		} else if (wd != null) {
			wd.dispose();
		} else if (fd != null) {
			fd.dispose();
		} else if (Cla != null) {
			Cla.dispose();
		}
		hp.setVisible(true);
	}

}

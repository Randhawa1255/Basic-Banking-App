package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.GUI.Closeacc;
import project.GUI.Createacc;
import project.GUI.Deposit;
import project.GUI.Find;
import project.GUI.Withdraw;
import project.GUI.homep;

public class OpenNwWin implements ActionListener {
	homep hp;
	int num;

	public OpenNwWin(homep hp, int num) {
		this.hp = hp;
		this.num = num;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (num == 0) {
			Createacc ca = new Createacc();
			ca.setVisible(true);
		} else if (num == 1) {
			Deposit dp = new Deposit();
			dp.setVisible(true);
		} else if (num == 2) {
			Withdraw wd = new Withdraw();
			wd.setVisible(true);
		} else if (num == 3) {
			Find fd = new Find();
			fd.setVisible(true);
		} else if (num == 4) {
			Closeacc cla = new Closeacc();
			cla.setVisible(true);
		}
		hp.dispose();

	}

}

package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import project.Logic;
import project.GUI.Createacc;


public class CreataccListener implements ActionListener {
	private Createacc label;
	Logic lo = new Logic();

	public CreataccListener(Createacc label) {
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mvdat();

	}

	public String[] store;
	int i = 0;

	public void mvdat() {
		JTextField[] val = label.getter();
		store = new String[val.length];
		boolean bool = false;
		i = 0;

		if (!val[0].getText().isBlank() && !val[1].getText().isBlank() && !val[2].getText().isBlank()
				&& !val[3].getText().isBlank()) {
			for (JTextField x : val) {
				store[i] = x.getText();
				i++;
			}
		} else {
			JOptionPane.showMessageDialog(label.CraBut, "Field is empty");
			return;
		}

		try {
			double opening = Double.parseDouble(store[3]);
			store[3] = Double.toString(opening);
			if (opening >= 0) {
				bool = true;
			}
			;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(label.CraBut, "You enter wrong value");
		}
		if (bool) {
			lo.crefile(store, label.temp);
			label.temp = Integer.toString(lo.getaccno());
			label.Cracclnum.setText(label.temp);
			JOptionPane.showMessageDialog(label.CraBut, "Account Created");
		}
	}
}

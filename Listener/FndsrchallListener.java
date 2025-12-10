package project.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import project.Logic;
import project.GUI.Find;

public class FndsrchallListener implements ActionListener {
	Logic lo = new Logic();
	ArrayList<String> s = lo.inforedall();
	String[] line;
	String convert;
	private Find fd;

	public FndsrchallListener(Find fd) {
		this.fd = fd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (lo.inforedall() != null) {
			fd.tdtm().setRowCount(0);
			for (int x = 0; s.size() != x; x++) {
				convert = s.get(x);
				line = convert.split(",");
				fd.tdtm().addRow(line);
			}
		} else {
			JOptionPane.showMessageDialog(fd, "No customer records to show.");
		}
	}

}

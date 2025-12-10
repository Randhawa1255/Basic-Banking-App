package project.GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import project.Listener.OpenNwWin;
import javax.swing.JButton;
import java.awt.Font;

public class homep extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homep frame = new homep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homep() {
		setFont(new Font("Calibri", Font.BOLD, 12));
		setTitle("Banking Basics");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JButton Creacc = new JButton("Create Account");
		Creacc.setFont(new Font("Calibri", Font.BOLD, 12));
		Creacc.setBounds(38, 52, 110, 43);
		Creacc.addActionListener(new OpenNwWin(this, 0));
		getContentPane().add(Creacc);

		JButton deposit = new JButton("Deposit");
		deposit.addActionListener(new OpenNwWin(this, 1));
		deposit.setFont(new Font("Calibri", Font.BOLD, 12));
		deposit.setBounds(38, 120, 110, 43);
		getContentPane().add(deposit);

		JButton withdraw = new JButton("Withdraw");
		withdraw.setFont(new Font("Calibri", Font.BOLD, 12));
		withdraw.setBounds(280, 120, 110, 43);
		withdraw.addActionListener(new OpenNwWin(this, 2));
		getContentPane().add(withdraw);

		JButton findacc = new JButton("Find Account");
		findacc.setFont(new Font("Calibri", Font.BOLD, 12));
		findacc.setBounds(280, 52, 110, 43);
		getContentPane().add(findacc);
		findacc.addActionListener(new OpenNwWin(this, 3));

		JButton cloacc = new JButton("Close Account");
		cloacc.setFont(new Font("Calibri", Font.BOLD, 12));
		cloacc.setBounds(165, 185, 110, 43);
		cloacc.addActionListener(new OpenNwWin(this, 4));
		getContentPane().add(cloacc);

	}
}

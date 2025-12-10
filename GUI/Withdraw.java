package project.GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project.Listener.CancelListener;
import project.Listener.WithdrawListener;
import project.Listener.WithdrawsubListener;

public class Withdraw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// search button
	private JTextField srwdtextf;
	// withdraw text field
	private JTextField wthdrwtxtf;
	private JLabel disInfo;
	private JLabel disInfo_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw();
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
	public Withdraw() {
		setTitle("Withdraw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// just label
		JLabel depl = new JLabel();
		depl.setText("Enter Account No:");
		depl.setBounds(9, 8, 121, 31);
		contentPane.add(depl);

		srwdtextf = new JTextField();
		srwdtextf.setBounds(140, 14, 162, 18);
		contentPane.add(srwdtextf);
		srwdtextf.setColumns(10);

		// button to search
		JButton depsearch = new JButton("Search");
		depsearch.setBounds(312, 13, 84, 20);
		contentPane.add(depsearch);
		depsearch.addActionListener(new WithdrawListener(this));
		// to display acc info
		disInfo = new JLabel("Name: ");
		disInfo.setBounds(10, 70, 200, 20);
		contentPane.add(disInfo);

		disInfo_1 = new JLabel("Balance: ");
		disInfo_1.setBounds(10, 100, 200, 20);
		contentPane.add(disInfo_1);

		// to display acc info
		JLabel depl_1 = new JLabel();
		depl_1.setText("Amount to withdraw");
		depl_1.setBounds(9, 172, 121, 31);
		contentPane.add(depl_1);

		// for withdraw
		wthdrwtxtf = new JTextField();
		wthdrwtxtf.setColumns(10);
		wthdrwtxtf.setBounds(140, 172, 153, 24);
		contentPane.add(wthdrwtxtf);

		// withdraw button
		JButton Withdraw = new JButton("Withdraw");
		Withdraw.setBounds(150, 206, 121, 33);
		contentPane.add(Withdraw);
		Withdraw.addActionListener(new WithdrawsubListener(this));

		JButton cancelbtn = new JButton("Go Back");
		cancelbtn.setFont(new Font("Calibri", Font.BOLD, 12));
		cancelbtn.setBounds(312, 213, 116, 26);
		contentPane.add(cancelbtn);
		cancelbtn.addActionListener(new CancelListener(this));
	}

	public String accnogetter() {
		return srwdtextf.getText();
	}

	public String valgetter() {
		return wthdrwtxtf.getText();
	}

	public void disn(String name) {
		disInfo.setText("Name: " + name);
	}

	public void disn1(String bal) {
		disInfo_1.setText("Balance: " + bal);
	}

	public Double balgetter() {
		String[] data = disInfo_1.getText().split(":");
		return Double.parseDouble(data[1].trim());
	}

}

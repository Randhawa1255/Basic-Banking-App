package project.GUI;

import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.Listener.CancelListener;
import project.Listener.DepositListener;
import project.Listener.DepositaddListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Deposit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Deptextf;
	private JTextField Deptxtf1;
	private JLabel disInfo;
	private JLabel disInfo_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setTitle("Deposit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel depl = new JLabel();
		depl.setText("Enter Account No:");
		depl.setBounds(9, 8, 121, 31);
		contentPane.add(depl);

		// search field
		Deptextf = new JTextField();
		Deptextf.setBounds(140, 14, 162, 18);
		contentPane.add(Deptextf);
		Deptextf.setColumns(10);

		// search button
		JButton depsearch = new JButton("Search");
		depsearch.setBounds(312, 13, 84, 20);
		contentPane.add(depsearch);
		depsearch.addActionListener(new DepositListener(this));

		disInfo = new JLabel("Name: ");
		disInfo.setBounds(10, 70, 102, 43);
		contentPane.add(disInfo);

		disInfo_1 = new JLabel("Balance: ");
		disInfo_1.setBounds(9, 104, 102, 43);
		contentPane.add(disInfo_1);

		JLabel depl_1 = new JLabel();
		depl_1.setText("Amount to deposit");
		depl_1.setBounds(9, 172, 121, 31);
		contentPane.add(depl_1);

		Deptxtf1 = new JTextField();
		Deptxtf1.setColumns(10);
		Deptxtf1.setBounds(140, 172, 153, 24);
		contentPane.add(Deptxtf1);

		JButton depositbtnn = new JButton("Deposit");
		depositbtnn.setBounds(161, 206, 84, 33);
		contentPane.add(depositbtnn);
		depositbtnn.addActionListener(new DepositaddListener(this));

		JButton cancelbtn = new JButton("Go Back");
		cancelbtn.setFont(new Font("Calibri", Font.BOLD, 12));
		cancelbtn.setBounds(310, 211, 116, 26);
		contentPane.add(cancelbtn);
		cancelbtn.addActionListener(new CancelListener(this));

	}

	public String accnogetter() {
		return Deptextf.getText();
	}

	public String valgetter() {
		return Deptxtf1.getText();
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

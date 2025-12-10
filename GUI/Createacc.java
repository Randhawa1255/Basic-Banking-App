package project.GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import project.Logic;
import project.Listener.CancelListener;
import project.Listener.CreataccListener;

import javax.swing.JLabel;

import java.awt.Font;


public class Createacc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Cracct;
	private JTextField Cracct_1;
	private JTextField Cracct_2;
	private JTextField Cracct_3;
	public JLabel Cracclnum;
	public JButton CraBut;
	Logic lo = new Logic();

	public String temp = Integer.toString(lo.getaccno());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Createacc frame = new Createacc();
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
	public Createacc() {
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// this one is lable
		JLabel Craccl = new JLabel("Account No");
		Craccl.setFont(new Font("Calibri", Font.BOLD, 12));
		Craccl.setBounds(56, 38, 84, 20);
		contentPane.add(Craccl);

		JLabel Craccl_1 = new JLabel("Name");
		Craccl_1.setFont(new Font("Calibri", Font.BOLD, 12));
		Craccl_1.setBounds(56, 68, 84, 20);
		contentPane.add(Craccl_1);

		JLabel Craccl_2 = new JLabel("Address");
		Craccl_2.setFont(new Font("Calibri", Font.BOLD, 12));
		Craccl_2.setBounds(56, 98, 84, 20);
		contentPane.add(Craccl_2);

		JLabel Craccl_3 = new JLabel("City");
		Craccl_3.setFont(new Font("Calibri", Font.BOLD, 12));
		Craccl_3.setBounds(56, 138, 84, 20);
		contentPane.add(Craccl_3);

		JLabel Craccl_4 = new JLabel("Opening Balance");
		Craccl_4.setFont(new Font("Calibri", Font.BOLD, 12));
		Craccl_4.setBounds(56, 171, 84, 20);
		contentPane.add(Craccl_4);

		// this one is for the Accnum
		Cracclnum = new JLabel();
		Cracclnum.setFont(new Font("Calibri", Font.BOLD, 12));
		Cracclnum.setBounds(213, 38, 84, 20);
		contentPane.add(Cracclnum);
		Cracclnum.setText(temp);

		// this for the input
		Cracct = new JTextField();
		Cracct.setBounds(213, 68, 84, 20);
		contentPane.add(Cracct);

		Cracct_1 = new JTextField();
		Cracct_1.setBounds(213, 98, 84, 20);
		contentPane.add(Cracct_1);

		Cracct_2 = new JTextField();
		Cracct_2.setBounds(213, 138, 84, 20);
		contentPane.add(Cracct_2);

		Cracct_3 = new JTextField();
		Cracct_3.setBounds(213, 171, 84, 20);
		contentPane.add(Cracct_3);

		// this one is button
		CraBut = new JButton("Create Account");
		CraBut.setFont(new Font("Calibri", Font.BOLD, 12));
		CraBut.setBounds(95, 214, 116, 26);
		contentPane.add(CraBut);
		CraBut.addActionListener(new CreataccListener(this));

		JButton cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(new Font("Calibri", Font.BOLD, 12));
		cancelbtn.setBounds(260, 214, 116, 26);
		contentPane.add(cancelbtn);
		cancelbtn.addActionListener(new CancelListener(this));
	}

	public JTextField[] getter() {
		JTextField[] val = { Cracct, Cracct_1, Cracct_2, Cracct_3 };
		return val;
	}

}

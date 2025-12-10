package project.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import project.Listener.CancelListener;
import project.Listener.DeleteaccListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Closeacc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Delaccno;
//	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Closeacc frame = new Closeacc();
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
	public Closeacc() {
		setTitle("Close Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Account No.");
		lblNewLabel.setBounds(10, 21, 80, 19);
		contentPane.add(lblNewLabel);

		Delaccno = new JTextField();
		Delaccno.setBounds(100, 21, 188, 18);
		contentPane.add(Delaccno);
		Delaccno.setColumns(10);

		JButton deletebtn = new JButton("Delete ");
		deletebtn.setBounds(316, 20, 84, 20);
		contentPane.add(deletebtn);
		deletebtn.addActionListener(new DeleteaccListener(this));

		JButton cancelbtn = new JButton("Go Back");
		cancelbtn.setFont(new Font("Calibri", Font.BOLD, 12));
		cancelbtn.setBounds(157, 209, 116, 26);
		contentPane.add(cancelbtn);
		cancelbtn.addActionListener(new CancelListener(this));

	}

	public String accnogetter() {
		return Delaccno.getText();
	}
}

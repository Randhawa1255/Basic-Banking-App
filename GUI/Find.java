package project.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import project.Listener.CancelListener;
import project.Listener.FndSrchListener;
import project.Listener.FndsrchallListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;


public class Find extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField findtxtf;
	private JTable table;
	private JScrollPane sp;
	public String[] Columns = { "Account No.", "Name", "Address", "City", "Balance" };
	DefaultTableModel dtm = new DefaultTableModel(Columns, 0) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find frame = new Find();
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
	public Find() {
		setTitle("Find Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Find");
		lblNewLabel.setBounds(10, 10, 58, 31);
		contentPane.add(lblNewLabel);

		findtxtf = new JTextField();
		findtxtf.setBounds(40, 16, 200, 18);
		contentPane.add(findtxtf);
		findtxtf.setColumns(10);

		JButton Searchbtn = new JButton("Search");
		Searchbtn.setBounds(250, 15, 84, 20);
		contentPane.add(Searchbtn);
		Searchbtn.addActionListener(new FndSrchListener(this));

		table = new JTable(dtm);
		sp = new JScrollPane(table);
		sp.setBounds(40, 51, 362, 179);
		contentPane.add(sp);

		JButton SearchAllbtn = new JButton("Search All");
		SearchAllbtn.setBounds(344, 15, 84, 20);
		contentPane.add(SearchAllbtn);
		SearchAllbtn.addActionListener(new FndsrchallListener(this));

		JButton cancelbtn = new JButton("Go Back");
		cancelbtn.setBounds(176, 233, 84, 20);
		contentPane.add(cancelbtn);
		cancelbtn.addActionListener(new CancelListener(this));

	}

	public String accnoget() {
		return findtxtf.getText();
	}

	public void tabset(String[] data) {
		dtm.addRow(data);
	}

	public JTable tableinfoget() {
		return table;
	}

	public DefaultTableModel tdtm() {
		return dtm;
	}
}

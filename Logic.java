package project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Logic {
	boolean bool = false;
	File file = new File("src//data.txt");
	String line = "";

	// keeps adding a new account row to the text file 
	public void crefile(String[] val, String accno) {
		try {
			file.createNewFile();

			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(accno + "," + Arrays.toString(val).replace("[", "").replace("]", "").replace(" ", "") + "\n");
			bw.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Could not save account: " + e.getMessage());
		}

	}

	// grab name + balance for one acc number
	public String[] readdata(String accno) {
		try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = rd.readLine()) != null) {
				String[] arr = line.split(",");
				// accno,name,address,city,balance
				if (arr[0].equals(accno)) {
					return new String[] { arr[1], arr[4] }; // name + balance
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Could not read info for acc " + accno + ": " + e.getMessage());
		}
		return null; 
	}

	// figure out the next acc number
	public int getaccno() {
		int num = 10000;
		try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
			String line;
			String[] s;
			while ((line = rd.readLine()) != null) {
				s = line.split(",");
				num = Integer.parseInt(s[0]);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Could not load acc numbers: " + e.getMessage());

		}

		return num + 1;

	}

	// for the find btn 
	public String[] infored(String accno) {
		String[] s;
		String Line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((Line = br.readLine()) != null) {
				s = Line.split(",");
				if (s[0].equals(accno)) {
					return s;
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Some problem with the file" + e.getMessage());
		}
		return null;
	}

	// for the find all btn
	public ArrayList<String> inforedall() {
		ArrayList<String> s = new ArrayList<String>();
		String Line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((Line = br.readLine()) != null) {
				s.add(Arrays.toString(Line.split(",")).replace("[", "").replace("]", "").replace(" ", ""));
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not load account list: " + e.getMessage());
		}
		if (s.size() == 0)
			return null;
		return s;
	}

	// update the balance for one account (writes whole file back)
	public void balchange(String accno, String total) {
		String[] s;
		String line;
		ArrayList<String> text = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				s = line.split(",");

				if (s[0].equals(accno)) {
					s[4] = total;
					line = String.join(",", s);
				}

				text.add(line);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error while updating balance for acc " + accno + ": " + e.getMessage());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (int x = 0; x < text.size(); x++) {
				bw.write(text.get(x));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not write updated balances: " + e.getMessage());
		}
	}

	// delete account
	public void delacc(String accno) {
		String[] s;
		String line;
		int re = -1;
		int fiVal = 0;
		ArrayList<String> text = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
	            line = line.trim(); 
	            if (line.isBlank()) continue;       
				s = line.split(",");
				re++;
				if (s[0].equals(accno)) {
					fiVal = re;
					bool = true;
				}

				text.add(line);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not load accounts to delete acc " + accno + ": " + e.getMessage());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			// System.out.print(fiVal);
			if (bool) {
				// to remove the accno from the array
				text.remove(fiVal);
			}
			for (int x = 0; x < text.size(); x++) {
				bw.write(text.get(x));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not write updated account list: " + e.getMessage());
		}
	}

	// check the delete flag
	public boolean boolgetter() {
		return bool;
	}

	public void boolsetter(boolean bool) {
		this.bool = bool;
	}

}

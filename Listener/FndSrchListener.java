package project.Listener;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import project.Logic;
import project.GUI.Find;

public class FndSrchListener implements ActionListener {
    private Find fd;
    Logic lo = new Logic();
    int x = 0;

    public FndSrchListener(Find fd) {
        this.fd = fd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("work-1");
        x = 0;
        int rows = fd.tableinfoget().getRowCount();
        boolean bool = true;
        
        if (fd.accnoget().isBlank()) {
        	JOptionPane.showMessageDialog(fd, "Enter a Value the Field is empty");
            return;
        }
        if(lo.infored(fd.accnoget()) == null) {
        	JOptionPane.showMessageDialog(fd, "Account Number Not Found");
        	return;
        }
        if (lo.infored(fd.accnoget()) != null) {
            //if their is no rows
            if (rows == 0) {
                // System.out.println("work");
                add();
                return;
            }
            do {
                String cellVal = fd.tableinfoget().getValueAt(x, 0).toString();
                // it check if the table already showing the val
                if (fd.accnoget().equals(cellVal)) {
                    JOptionPane.showMessageDialog(fd, "All ready Showing in table");
                    bool = false;
                    break;
                } 
                x++;
            } while (x < rows);

            if (bool) {
                add();
            }
        }
    }

    public void add() {
        x = 0;
        fd.tabset(lo.infored(fd.accnoget()));
    }
}

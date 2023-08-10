package hostelmanagementsystem.Students;

import hostelmanagementsystem.Admin.UserSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu1 extends JFrame {

    private UserSession userSession;
    private JTable table;

    public Menu1(UserSession userSession) {
        // Define User Session
        this.userSession = userSession;

        initComponents();
        importData();
    }

    private void initComponents() {
        table = new JTable();
        JScrollPane jScrollPane1 = new JScrollPane();
        JButton backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu1");

        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "ID", "Name", "Age", "Email", "Address", "Course", "Intake", "Zipcode", "Card Number", "CVV"
                }
        ));
        jScrollPane1.setViewportView(table);

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(backButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backButton)
                                .addContainerGap())
        );

        pack();
    }

    private void importData() {
        String filepath = "FormSub.txt";
        File file = new File(filepath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 10) { // Assuming CVV is at index 9
                    data[9] = maskCVV(data[9]); // Mask the CVV value
                    model.addRow(data);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String maskCVV(String cvv) {
        StringBuilder maskedCVV = new StringBuilder();
        for (int i = 0; i < cvv.length(); i++) {
            maskedCVV.append("*"); // Mask each character of the CVV with an asterisk
        }
        return maskedCVV.toString();
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        // Code to navigate back to the student dashboard or previous page
        // Implement your desired functionality here
        // For example, you can create and show a new instance of the StudentDashboard class
        StudentDashboard studentDashboard = new StudentDashboard(userSession);
        studentDashboard.setVisible(true);
        this.dispose(); // Close the current menu window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserSession userSession = new UserSession("student");
            Menu1 menu1 = new Menu1(userSession);
            menu1.setVisible(true);
        });
    }
}


/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

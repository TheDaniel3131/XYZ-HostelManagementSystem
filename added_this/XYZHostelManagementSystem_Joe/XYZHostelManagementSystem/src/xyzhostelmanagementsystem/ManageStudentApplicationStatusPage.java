/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzhostelmanagementsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Killi
 */
public class ManageStudentApplicationStatusPage extends javax.swing.JFrame {
String filepath = "C:\\Users\\Killi\\OneDrive\\桌面\\Java Assigment\\FormSub.txt";
//        File file = new File(filepath);
    /**
     * Creates new form ManageStudentApplicationStatusPage
     */
    public ManageStudentApplicationStatusPage() {
        initComponents();
        importData();
    }
//      void UpdateData(){
//        try {
//            RandomAccessFile raf = new RandomAccessFile(file+"\\FormSub.txt","rw");
//            raf.writeBytes(""+ jComboBox2.getSelectedItem().toString() + ",");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    void UpdateData() {
//    String newStatus = jComboBox2.getSelectedItem().toString();
//    int row = jTable1.getSelectedRow();
//    String studentIDSelected = jTable1.getModel().getValueAt(row, 0).toString();
//    String tempFile = "C:\\Users\\Killi\\OneDrive\\桌面\\Java Assigment\\temp.txt";
//    File oldFile = new File(filepath);
//    File newFile = new File(tempFile);
//
//    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true)))) {
//        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//            String information;
//            while ((information = br.readLine()) != null) {
//                String[] data = information.split(",");
//                if (data[0].equals(studentIDSelected)) {
//                    pw.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + newStatus);
//                    JOptionPane.showMessageDialog(this, "The data has been modified successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    pw.println(information);
//                }
//            }
//            br.close();
//        } catch (IOException ioe) {
//            JOptionPane.showMessageDialog(this, "Something went wrong with reading the file!", "Error Message", JOptionPane.ERROR_MESSAGE);
//        }
//
//        // Close the PrintWriter after the loop finishes
//        pw.close();
//
//        // Delete the old file
//        if (!oldFile.delete()) {
//        // Rename the new file to replace the old file
//        newFile.renameTo(oldFile);
//        } else {
//        String errorMessage = "Failed to delete the old file.";
//        if (!oldFile.exists()) {
//            errorMessage += " The file does not exist.";
//        } else if (!oldFile.isFile()) {
//            errorMessage += " The path points to a directory, not a file.";
//        } else if (!oldFile.canWrite()) {
//            errorMessage += " No write permission for the file.";
//        }
//        JOptionPane.showMessageDialog(this, errorMessage, "Error Message", JOptionPane.ERROR_MESSAGE);
//        }
//
//    } catch (IOException ioe) {
//        JOptionPane.showMessageDialog(this, "Error occurred while writing the file.", "Error Message", JOptionPane.ERROR_MESSAGE);
//    }
    void UpdateData() {
    String newStatus = jComboBox2.getSelectedItem().toString();
    int row = jTable1.getSelectedRow();
    String studentIDSelected = jTable1.getModel().getValueAt(row, 0).toString();
    File file = new File(filepath);
    ArrayList<String> temp = new ArrayList<>();
    
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String information;
        while ((information = br.readLine()) != null) {
            String[] data = information.split("\\|");
            if (data[0].equals(studentIDSelected)) {
                temp.add(data[0] + "|" + data[1] + "|" + data[2] + "|" + data[3] + "|" + data[4] + "|" + data[5] + "|" + data[6] + "|" + data[7] + "|" + data[8] + "|" + data[9] + "|" + data[10] + "|" + data[11] + "|" + data[12] + "|" + newStatus + "|" + data[13]);
            } else {
                temp.add(information);
            }
        }
    } catch (IOException ex) {
        Logger.getLogger(ManageStudentApplicationStatusPage.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
        for (String data : temp) {
            pw.println(data);
        }
    } catch (IOException ex) {
        Logger.getLogger(ManageStudentApplicationStatusPage.class.getName()).log(Level.SEVERE, null, ex);
    }
}


   private void importData(){
    String filepath = "C:\\Users\\Killi\\OneDrive\\桌面\\Java Assigment\\FormSub.txt";
    File file = new File(filepath);

    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\|"); // Split using the "|" character
            model.addRow(data);
        }
    } catch (Exception ex) {
        Logger.getLogger(ManageStudentApplicationStatusPage.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID", "StudentName", "Age", "Email", "Address", "Course", "Intake", "Zip Code ", "State", "CardNumber", "CVV", "Room Type", "Room Price", "Status", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Manage Student Application Status Page");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approve", "Reject" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Applciation Status ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(96, 220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String jC1= jComboBox2.getSelectedItem().toString();
UpdateData();// TODO add your handling code here:
DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
table.setRowCount(0);
importData();

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudentApplicationStatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudentApplicationStatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudentApplicationStatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudentApplicationStatusPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudentApplicationStatusPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

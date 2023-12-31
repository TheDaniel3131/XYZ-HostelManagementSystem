/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostelmanagementsystem.Students;

import hostelmanagementsystem.Admin.FilesLocation;
import hostelmanagementsystem.Admin.UserSession;
import java.awt.HeadlessException;
import hostelmanagementsystem.Students.LoginForm;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Killi
 */
public class Registration extends javax.swing.JFrame implements FilesLocation {

    int in;
    String StudentID, Username, Password, Confirmpassword, Gender, PhoneNumber, EmailAddress, Nationality;
    private UserSession userSession;

    private int studentIdCounter1;
    private int studentIdCounter2;

    ImageIcon wi = new ImageIcon("thelogo.jpg");

    private void readFile() {
        File file = new File(REGISTRATION_FILE_PATH);
        if (file.exists()) {
            System.err.println("File exists!");
        } else {
            try {
                FileWriter fw = new FileWriter(file);
                System.out.println("File created");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addData() {
        try ( FileWriter fw = new FileWriter(REGISTRATION_FILE_PATH, true);  BufferedWriter writer = new BufferedWriter(fw)) {

            String studentId = "SID" + studentIdCounter1;
            studentIdCounter1++;

            writer.write(studentId + "|");
            writer.write(Username + "|");
            writer.write(Password + "|");
            writer.write(Confirmpassword + "|");
            writer.write(PhoneNumber + "|");
            writer.write(EmailAddress + "|");
            writer.write(Nationality + "|");
            writer.write(jComboBox1.getSelectedItem().toString() + "|");
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        storeCounterToFile(COUNTER1_FILE_PATH, studentIdCounter1);
    }

    private void addC() {
        try ( FileWriter fw = new FileWriter("loginC.txt", true);  BufferedWriter writer = new BufferedWriter(fw)) {

            String studentId = "SID" + studentIdCounter2;
            studentIdCounter2++;

            writer.write(studentId + "|");
            writer.write(Password + "|");
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        storeCounterToFile(COUNTER2_FILE_PATH, studentIdCounter2);
    }

    private int readCounterFromFile(String filePath, int defaultValue) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String counterValueString = reader.readLine();
            if (counterValueString != null) {
                return Integer.parseInt(counterValueString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    private void storeCounterToFile(String filePath, int counterValue) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(counterValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new form Registration
     */
    public Registration(UserSession userSession) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        studentIdCounter1 = readCounterFromFile(COUNTER1_FILE_PATH, 1);
        studentIdCounter2 = readCounterFromFile(COUNTER2_FILE_PATH, 1);

        //Window itself
        this.setIconImage(wi.getImage());
        this.setTitle("Student Registration | XYZ Hostel");
        this.setSize(770, 500);

        // Window when close
        this.setDefaultCloseOperation(Registration.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegisterStudent = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tf7 = new javax.swing.JTextField();
        tf8 = new javax.swing.JTextField();
        tf9 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf10 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(23, 93, 74));
        jPanel1.setMinimumSize(new java.awt.Dimension(770, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 500));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registration Form");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 20, 387, 66);

        btnRegisterStudent.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        btnRegisterStudent.setText("Submit");
        btnRegisterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterStudentActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegisterStudent);
        btnRegisterStudent.setBounds(190, 390, 109, 56);

        jButton2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(320, 390, 109, 56);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(468, 204, 0, 0);

        jButton3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(440, 390, 107, 57);

        jPanel2.setBackground(new java.awt.Color(42, 167, 71));
        jPanel2.setLayout(null);
        jPanel2.add(tf7);
        tf7.setBounds(510, 50, 114, 24);
        jPanel2.add(tf8);
        tf8.setBounds(510, 100, 114, 24);

        tf9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf9ActionPerformed(evt);
            }
        });
        jPanel2.add(tf9);
        tf9.setBounds(510, 150, 114, 24);

        jLabel7.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PHONE NUMBER:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(370, 50, 120, 16);

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EMAIL ADDRESS:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(371, 100, 120, 24);

        jLabel11.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NATIONALITY:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(370, 150, 110, 24);

        jLabel10.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("STUDENT NAME:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(30, 40, 120, 24);

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 90, 90, 20);
        jPanel2.add(tf10);
        tf10.setBounds(190, 40, 117, 24);
        jPanel2.add(tf3);
        tf3.setBounds(190, 90, 117, 24);
        jPanel2.add(tf4);
        tf4.setBounds(190, 140, 117, 24);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Gender", "Male", "Female" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(190, 190, 117, 26);

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CONFIRM PASSWORD:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 140, 160, 24);

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GENDER:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 190, 100, 24);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 90, 680, 280);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 790, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoginForm LF2 = new LoginForm(userSession);
        LF2.setVisible(true);
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    @SuppressWarnings("ConvertToTryWithResources")
    private void btnRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterStudentActionPerformed
        Username = tf10.getText();
        Password = tf3.getText();
        Confirmpassword = tf4.getText();
        PhoneNumber = tf7.getText();
        EmailAddress = tf8.getText();
        Nationality = tf9.getText();
        String jC1 = jComboBox1.getSelectedItem().toString();
        if (Username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username is mandatory.");
        } else if (Password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password is mandatory.");
        } else if (Confirmpassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Confirm Password is mandatory.");
        } else if (EmailAddress.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email Address is mandatory.");
        } else if (PhoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone Number is mandatory.");
        } else if (!Password.equals(Confirmpassword)) {
            JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!EmailAddress.matches("[\\w.]+@[\\w.]+\\.\\w+")) {
            JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!PhoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jC1.equals("Select a Gender")) {
            JOptionPane.showMessageDialog(null, "Please select a gender.");
        } else {
            JOptionPane.showMessageDialog(null, "Form has been successfully submitted!");
            readFile();
            addData();
            addC();
            this.dispose();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterStudentActionPerformed

    private void tf9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        tf3.setText("");
        tf4.setText("");
        tf7.setText("");
        tf8.setText("");
        tf9.setText("");
        tf10.setText("");  // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserSession userSession = new UserSession("student");
                new Registration(userSession).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegisterStudent;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField tf10;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf7;
    private javax.swing.JTextField tf8;
    private javax.swing.JTextField tf9;
    // End of variables declaration//GEN-END:variables
}

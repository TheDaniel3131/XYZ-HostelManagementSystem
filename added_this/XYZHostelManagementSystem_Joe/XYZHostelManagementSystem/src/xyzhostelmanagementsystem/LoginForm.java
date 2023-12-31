/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzhostelmanagementsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import xyzhostelmanagementsystem.Registration;

/**
 *
 * @author Killi
 */
public class LoginForm extends javax.swing.JFrame {

    File f = new File("C:\\Users\\Killi\\OneDrive\\桌面\\Java Assigment");
    int in;
    String StudentID, Password;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    void createFolder() {
        if (f.exists()) {
            f.mkdirs();
        }
    }

    void readFile() {
        FileReader fr = null;
        try {
            fr = new FileReader(f + "\\loginC.txt");
            System.err.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + "\\loginC.txt");
                System.out.println("File Created");
            } catch (IOException ex1) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void addData(String usr, String pswd) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\loginC.txt", "rw");
            for (int i = 0; i < in; i++) {
                raf.readLine();
            }
            if (in > 0) {
                raf.writeBytes("\r\n");
            }
            raf.writeBytes("Username:" + usr + "\r\n");
            raf.writeBytes("Password:" + pswd + "\r\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void CheckData(String usr, String pswd) {

        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\loginC.txt", "rw");
            String line = raf.readLine();
            StudentID = line.substring(9);
            Password = raf.readLine().substring(9);
            if (usr.equals(StudentID) & pswd.equals(Password)) {
                JOptionPane.showMessageDialog(null, "Password Matched");
                StudentDashboard DBl = new StudentDashboard();
                DBl.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid User/Password");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void countLine() {
        try {
            in = 1;
            RandomAccessFile raf = new RandomAccessFile(f + "\\loginC.txt", "rw");
            for (int i = 0; raf.readLine() != null; i++) {
                in++;
            }
            System.out.println("number of lines:" + in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   void logic(String usr, String pswd) {
    try (BufferedReader br = new BufferedReader(new FileReader(f + "\\loginC.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\|");
            String forUser = data[0];
            String forPswd = data[1];
            
            if (usr.equals(forUser) && pswd.equals(forPswd)) {
                JOptionPane.showMessageDialog(null, "Password Matched");
                StudentDashboard DBl = new StudentDashboard();
                DBl.setVisible(true);
                this.setVisible(false);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
    } catch (FileNotFoundException ex) {
        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfuser = new javax.swing.JTextField();
        tfpswd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Login | XYZ Hostel ");
        setBackground(new java.awt.Color(0, 102, 204));
        setMinimumSize(new java.awt.Dimension(800, 480));
        setSize(new java.awt.Dimension(800, 480));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 480));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 480));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 480));
        jPanel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xyzhostelmanagementsystem/463271_16091517490046512024_1024x682_1_386x412.jpg"))); // NOI18N
        jLabel1.setName(""); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 70, 386, 386);

        jButton1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 20, 110, 40);

        jPanel1.setBackground(new java.awt.Color(199, 213, 224));
        jPanel1.setForeground(new java.awt.Color(199, 213, 224));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        tfuser.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        tfuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfuserActionPerformed(evt);
            }
        });
        jPanel1.add(tfuser);
        tfuser.setBounds(170, 40, 160, 38);

        tfpswd.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jPanel1.add(tfpswd);
        tfpswd.setBounds(170, 90, 160, 38);

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 40, 56));
        jLabel3.setText("StudentID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(54, 40, 80, 32);

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 40, 56));
        jLabel4.setText("Password:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 90, 90, 32);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(450, 110, 370, 160);

        jButton2.setBackground(new java.awt.Color(27, 40, 56));
        jButton2.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(450, 300, 210, 130);

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("STUDENT LOGIN ");
        jLabel2.setAlignmentX(0.5F);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(460, 50, 280, 40);

        jButton3.setBackground(new java.awt.Color(27, 40, 56));
        jButton3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setText("Swing");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(670, 370, 160, 60);

        jButton4.setBackground(new java.awt.Color(27, 40, 56));
        jButton4.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Register");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(670, 300, 160, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfuserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        createFolder();
        readFile();
        countLine();
        logic(tfuser.getText(), tfpswd.getText());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        createFolder();
        readFile();
        countLine();

// TODO add your handling code here:

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Registration Sel = new Registration();
        Sel.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfpswd;
    private javax.swing.JTextField tfuser;
    // End of variables declaration//GEN-END:variables
}

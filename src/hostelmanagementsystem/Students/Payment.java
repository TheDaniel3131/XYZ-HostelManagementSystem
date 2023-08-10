/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostelmanagementsystem.Students;

import hostelmanagementsystem.Admin.FilesLocation;
import hostelmanagementsystem.Admin.LandingPage;
import hostelmanagementsystem.Admin.UserSession;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import javax.swing.ImageIcon;

/**
 *
 * @author Killi
 */
public class Payment extends javax.swing.JFrame implements FilesLocation {

    private UserSession userSession;

    ImageIcon wi = new ImageIcon("thelogo.jpg");
    int in;
    private String Name, Email, Course, Intake, CardNumber, Age, Address, ZipCode, CVV, RoomNo, RoomPrice, RoomType;
    private String paymentstate;
    private int studentIdCounter = 1;
    private String[] formData;
    private LocalDate currentDate;

    public Payment(UserSession userSession) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Window itself
        this.setSize(820, 580);
        this.setIconImage(wi.getImage());
        this.setTitle("Payment of Book Hostel | XYZ Hostel");

        // Window when close
        this.setDefaultCloseOperation(LandingPage.EXIT_ON_CLOSE);
        this.setVisible(false);

        studentIdCounter = readCounterFromFile(COUNTERP_FILE_NAME, 1);
        currentDate = LocalDate.now();
    }

    private int readCounterFromFile(String fileName, int defaultValue) {
        try {
            File counterFile = new File(fileName);
            if (counterFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(counterFile));
                String counterValueString = reader.readLine();
                reader.close();
                if (counterValueString != null) {
                    return Integer.parseInt(counterValueString);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    private void storeCounterToFile(String fileName, int counterValue) {
        try {
            File counterFile = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(counterFile));
            writer.write(String.valueOf(counterValue));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Payment(String[] formData) {
        initComponents();
        this.formData = formData;
        setData(formData);
    }

    public void setData(String[] formData) {
        txtf1.setText(formData[0]);
        CF.setText(formData[1]);
        EF.setText(formData[2]);
        IF.setText(formData[3]);
        AF.setText(formData[4]);
        AgeF.setText(formData[5]);
        txtRoomNo.setText(formData[6]);
        RPF.setText(formData[7]);
        RTF.setText(formData[8]);
    }

    void addData() {
        try {
            File formFile = new File(FORMSUB_FILE_PATH);
            FileWriter fileWriter = new FileWriter(formFile, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String studentId = "SID" + studentIdCounter;
            String paymentState = "Pending";

            if (currentDate == null) {
                currentDate = LocalDate.now();
            }

            String data = String.join("|",
                    studentId, getName(), getAge(), getEmail(), getAddress(),
                    getCourse(), getIntake(), getZipCode(),
                    getCardNumber(), getCVV(), getRoomNumber(), getRoomType(), getRoomPrice(),
                    paymentState, currentDate.toString());

            writer.write(data);
            writer.newLine();
            writer.close();

            studentIdCounter++;
            storeCounterToFile(COUNTERP_FILE_NAME, studentIdCounter);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        this.Course = course;
    }

    public String getIntake() {
        return Intake;
    }

    public void setIntake(String intake) {
        this.Intake = intake;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.CardNumber = cardNumber;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getpaymentstate() {
        return paymentstate;
    }

    public void setpaymentstate(String state) {
        this.paymentstate = state;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        this.ZipCode = zipCode;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String cvv) {
        this.CVV = cvv;
    }

    public String getRoomNumber() {
        return RoomNo;
    }

    public void setRoomNumber(String roomNumber) {
        this.RoomNo = roomNumber;
    }

    public String getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.RoomPrice = roomPrice;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        this.RoomType = roomType;
    }

    /**
     * Creates new form Payment
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        EF = new javax.swing.JTextField();
        RPF = new javax.swing.JTextField();
        txtf1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AF = new javax.swing.JTextField();
        AgeF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        IF = new javax.swing.JTextField();
        CF = new javax.swing.JTextField();
        CVF = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CNF = new javax.swing.JTextField();
        RTF = new javax.swing.JTextField();
        ZF = new javax.swing.JTextField();
        SF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtRoomNo = new javax.swing.JTextField();

        jTextField5.setText("jTextField1");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Email:");

        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));
        setMinimumSize(new java.awt.Dimension(800, 480));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit Form");
        jButton2.setActionCommand("jbutton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(200, 560, 420, 47);

        btnGoBack.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGoBack.setText("Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnGoBack);
        btnGoBack.setBounds(30, 30, 110, 40);

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel4.setText("Student Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(42, 109, 100, 14);

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel5.setText("Age:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 160, 60, 20);

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel1.setText("Zip Code:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(420, 110, 70, 24);

        EF.setToolTipText("");
        EF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EFActionPerformed(evt);
            }
        });
        jPanel1.add(EF);
        EF.setBounds(158, 211, 200, 40);

        RPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPFActionPerformed(evt);
            }
        });
        jPanel1.add(RPF);
        RPF.setBounds(540, 460, 200, 40);

        txtf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtf1);
        txtf1.setBounds(158, 95, 200, 40);

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel2.setText("Address:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 280, 70, 24);

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel6.setText("State:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(420, 170, 50, 19);

        AF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AFActionPerformed(evt);
            }
        });
        jPanel1.add(AF);
        AF.setBounds(158, 271, 200, 40);

        AgeF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeFActionPerformed(evt);
            }
        });
        jPanel1.add(AgeF);
        AgeF.setBounds(158, 153, 200, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hostel Payment Page");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(210, 30, 390, 44);

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel8.setText("Email:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 220, 50, 20);

        jLabel10.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel10.setText("Course:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 340, 80, 20);

        jLabel11.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel11.setText("CVV:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(420, 280, 34, 20);
        jPanel1.add(IF);
        IF.setBounds(158, 406, 200, 40);

        CF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CFActionPerformed(evt);
            }
        });
        jPanel1.add(CF);
        CF.setBounds(158, 329, 200, 40);

        CVF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVFActionPerformed(evt);
            }
        });
        jPanel1.add(CVF);
        CVF.setBounds(540, 270, 200, 32);

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel3.setText("Room Type:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(420, 390, 90, 30);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(418, 387, 0, 0);

        jLabel13.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel13.setText("Room Price:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(420, 470, 80, 24);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Card Number:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(420, 220, 110, 20);

        jLabel15.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel15.setText("Intake:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(50, 410, 80, 20);

        CNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNFActionPerformed(evt);
            }
        });
        jPanel1.add(CNF);
        CNF.setBounds(540, 210, 200, 40);

        RTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RTFActionPerformed(evt);
            }
        });
        jPanel1.add(RTF);
        RTF.setBounds(540, 390, 200, 40);

        ZF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZFActionPerformed(evt);
            }
        });
        jPanel1.add(ZF);
        ZF.setBounds(540, 90, 200, 40);

        SF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SFActionPerformed(evt);
            }
        });
        jPanel1.add(SF);
        SF.setBounds(540, 150, 200, 40);

        jLabel16.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel16.setText("Room No:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(420, 330, 90, 30);

        txtRoomNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomNoActionPerformed(evt);
            }
        });
        jPanel1.add(txtRoomNo);
        txtRoomNo.setBounds(540, 330, 200, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 830, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EFActionPerformed

    private void RPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RPFActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void txtf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf1ActionPerformed

    private void AFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AFActionPerformed

    private void AgeFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeFActionPerformed

    private void CFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CFActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Name = txtf1.getText();
        Age = AgeF.getText();
        Course = CF.getText();
        Email = EF.getText();
        Intake = IF.getText();
        CardNumber = CNF.getText();
        Address = AF.getText();
        paymentstate = SF.getText();
        ZipCode = ZF.getText();
        CVV = CVF.getText();
        RoomNo = txtRoomNo.getText();
        RoomType = RTF.getText();
        RoomPrice = RPF.getText();

        if (Name.isEmpty() || Age.isEmpty() || Course.isEmpty() || Email.isEmpty()
                || Intake.isEmpty() || CardNumber.isEmpty() || Address.isEmpty()
                || paymentstate.isEmpty() || ZipCode.isEmpty() || CVV.isEmpty() || RoomType.isEmpty()
                || RoomPrice.isEmpty()) {
            // Display an error message if any of the fields are empty
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!Age.matches("\\d+")) {
            // Validate the age field using regex to ensure it contains only digits
            JOptionPane.showMessageDialog(this, "Invalid age. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!Email.matches("[\\w.]+@[\\w.]+\\.\\w+")) {
            // Validate the email field using regex to ensure it has a valid email format
            JOptionPane.showMessageDialog(this, "Invalid email address. Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Invalid email address. Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!ZipCode.matches("\\d{5}")) {
            // Validate the zip code field using regex to ensure it has exactly 5 digits
            JOptionPane.showMessageDialog(this, "Invalid zip code. Please enter a 5-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!CVV.matches("\\d{3}")) {
            // Validate the CVV field using regex to ensure it has exactly 3 digits
            JOptionPane.showMessageDialog(this, "Invalid CVV. Please enter a 3-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Address.length() < 5) {
        } else {
            JOptionPane.showMessageDialog(this, "The Form has successfully Submitted! Thank you");
            this.dispose();
        }

        addData();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CVFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CVFActionPerformed

    private void CNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNFActionPerformed

    private void RTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RTFActionPerformed

    private void ZFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZFActionPerformed

    private void SFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SFActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed

        HostelApplicationForm haf = new HostelApplicationForm(userSession);
        haf.setLocationRelativeTo(null);
        haf.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void txtRoomNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomNoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserSession userSession = new UserSession("student");
                new Payment(userSession).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AF;
    private javax.swing.JTextField AgeF;
    private javax.swing.JTextField CF;
    private javax.swing.JTextField CNF;
    private javax.swing.JPasswordField CVF;
    private javax.swing.JTextField EF;
    private javax.swing.JTextField IF;
    private javax.swing.JTextField RPF;
    private javax.swing.JTextField RTF;
    private javax.swing.JTextField SF;
    private javax.swing.JTextField ZF;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtf1;
    // End of variables declaration//GEN-END:variables
}

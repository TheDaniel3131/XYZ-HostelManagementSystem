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
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 *
 * @author Killi
 */
public class Payment extends javax.swing.JFrame {

    File f = new File("C:\\Users\\Killi\\OneDrive\\桌面\\Java Assigment");
    int in;
    String Name, Email, Course, Intake, CardNumber, Age, Address, ZipCode, CVV, RoomPrice, RoomType;
    private String paymentstate;
    private String[] formData;
    LocalDate currentDate = LocalDate.now();
    private int studentIdCounter = 1;
    int Column_row_Size = 100;
    private File counterFile;

    public Payment() {
        initComponents();
        File F = new File("C:\\Users\\Killi\\OneDrive\\桌面\\Java Assigment\\studentIdCounterPayment.txt");
        studentIdCounter = readCounterFromFile3(f + "studentIdCounterPayment.txt", 1);
    }

    private int readCounterFromFile3(String fileName, int defaultValue) {
        try {
            FileReader fileReader = new FileReader(f + "\\studentIdCounterPayment.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String counterValueString = bufferedReader.readLine();
            bufferedReader.close();
            if (counterValueString != null) {
                return Integer.parseInt(counterValueString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    private void storeCounterToFile3(String fileName, int counterValue) {
        try {
            FileWriter fileWriter = new FileWriter(f + "\\studentIdCounterPayment.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(counterValue));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Payment(String[] formData) {
        initComponents();
        this.formData = formData;
        txtf1.setText(formData[0]);
        CF.setText(formData[1]);
        AgeF.setText(formData[5]);
        EF.setText(formData[2]);
        IF.setText(formData[3]);
        AF.setText(formData[4]);
        RPF.setText(formData[7]);
        RTF.setText(formData[8]);
    }

    public void setData(String[] formData) {
        txtf1.setText(formData[0]);
        CF.setText(formData[1]);
        EF.setText(formData[2]);
        IF.setText(formData[3]);
        AF.setText(formData[4]);
        AgeF.setText(formData[5]);
        RPF.setText(formData[7]);
        RTF.setText(formData[8]);

    }

    void addData() {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\FormSub.txt", "rw");
            raf.seek(raf.length());
            String studentId = "SID" + studentIdCounter;
            raf.writeBytes(studentId + "|");
            raf.writeBytes(getName() + "|");
            raf.writeBytes(getAge() + "|");
            raf.writeBytes(getEmail() + "|");
            raf.writeBytes(getAddress() + "|");
            raf.writeBytes(getCourse() + "|");
            raf.writeBytes(getIntake() + "|");
            raf.writeBytes(getZipCode() + "|");
            raf.writeBytes(getpaymentstate() + "|");
            raf.writeBytes(getCardNumber() + "|");
            raf.writeBytes(getCVV() + "|");
            raf.writeBytes(getRoomType() + "|");
            raf.writeBytes(getRoomPrice() + "|");
            raf.writeBytes("Pending" + "|");
            raf.writeBytes(currentDate.toString());
            raf.writeBytes("\r\n");
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        storeCounterToFile3(f + "studentIdCounterPayment.txt", studentIdCounter);

        // Getter and setter methods for encapsulated variables
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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

        jButton1.setText("Back");

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Submit Form");
        jButton2.setActionCommand("jbutton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Student Name");

        jLabel5.setText("Age:");

        jLabel1.setText("Zip Code:");

        EF.setToolTipText("");
        EF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EFActionPerformed(evt);
            }
        });

        RPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPFActionPerformed(evt);
            }
        });

        txtf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Address:");

        jLabel6.setText("State:");

        AF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AFActionPerformed(evt);
            }
        });

        AgeF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeFActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setText("Hostel Payment Page");

        jLabel8.setText("Email:");

        jLabel10.setText("Course");

        jLabel11.setText("CVV:");

        CF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CFActionPerformed(evt);
            }
        });

        CVF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVFActionPerformed(evt);
            }
        });

        jLabel3.setText("Room Type");

        jLabel13.setText("Room Price");

        jLabel14.setText("Card Number:");

        jLabel15.setText("Intake");

        CNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNFActionPerformed(evt);
            }
        });

        RTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RTFActionPerformed(evt);
            }
        });

        ZF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZFActionPerformed(evt);
            }
        });

        SF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AgeF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtf1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(AF))
                                .addComponent(IF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))))
                    .addComponent(CF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RPF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(RTF)
                    .addComponent(CVF)
                    .addComponent(CNF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(SF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(ZF))
                .addGap(0, 111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtf1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(ZF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgeF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CNF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CVF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(IF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RPF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

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
        RoomType = RTF.getText();
        RoomPrice = RPF.getText();
        addData();

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
                new Payment().setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtf1;
    // End of variables declaration//GEN-END:variables
}

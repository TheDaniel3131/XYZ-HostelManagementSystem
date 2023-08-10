/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hostelmanagementsystem.Admin;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class generateIR extends javax.swing.JFrame {

    /**
     * Creates new form AdminGenerateReport
     */
    ImageIcon wi = new ImageIcon("thelogo.jpg");
    private UserSession userSession;

    // declare the variables that will hold the data read from the file
    private double totalRentPerMonth;
    private int totalStudents;
    private int approvedStudents;
    private int rejectedStudents;
    private int totalRooms;
    private int occupiedRooms;
    private double otherIncomePerMonth;
    private double staffSalaryPerMonth;
    private double utilitiesPerMonth;
    private double maintenancePerMonth;

    public generateIR(UserSession userSession) {

        //Define User Session
        this.userSession = userSession;

        // Window
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        // Window itself
        this.setTitle("Generate Report Invoice | XYZ Hostel Management");
        this.setSize(1200, 820);

        //Window itself
        this.setIconImage(wi.getImage());

        // Window when close
        this.setDefaultCloseOperation(LandingPage.EXIT_ON_CLOSE);
        this.setVisible(false);

        // Monthly Report Month & Year 
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1; // add 1 to get month from 1 to 12
        int year = cal.get(Calendar.YEAR);

        String monthYear = String.format("%02d/%d", month, year); // format the string to display month and year with leading zeros
        lblMonthYear.setText(monthYear);

        // Admin Name
        lblAdminName.setText("Daniel Poh");

        // Admin Info Corner (GR_admininfo.txt)
        try {
            Scanner aa = new Scanner(new File("GR_admininfo.txt"));
            StringBuilder sb = new StringBuilder();
            while (aa.hasNextLine()) {
                sb.append(aa.nextLine()).append("<br>"); // add line breaks
            }
            aa.close();
            lblAdminAddress.setText("<html>" + sb.toString() + "</html>"); // set text with HTML formatting
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Admin Created Invoice Report Date 
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm");
        LocalDateTime currDateTime = LocalDateTime.now();
        lblcreatedDateMR.setText(dateTimeFormat.format(currDateTime));

        try ( Scanner scanner = new Scanner(new File("FormSub.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");

                String roomPrice = data[12]; // Adjust the index to match the correct field

                // Exclude rows with "pending" payment status
                String paymentStatus = data[13]; // Adjust the index to match the correct field
                if (!paymentStatus.equalsIgnoreCase("pending")) {
                    String numericRoomPrice = roomPrice.replace("RM", ""); // Remove the "RM" prefix
                    totalRentPerMonth += Double.parseDouble(numericRoomPrice);
                    totalStudents++;

                    if (paymentStatus.equalsIgnoreCase("approve")) {
                        approvedStudents++;
                    } else if (paymentStatus.equalsIgnoreCase("reject")) {
                        rejectedStudents++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read the data from the file and store it in the variables (calc.txt)
        try {
            // read the data from calc.txt
            Scanner scanner = new Scanner(new File("C:\\Users\\danie\\Documents\\NetBeansProjects\\HostelManagementSystem\\calc.txt"));
            scanner.nextLine(); // skip the first line
            totalRentPerMonth = Double.parseDouble(scanner.nextLine().split(": ")[1]);
            totalStudents = Integer.parseInt(scanner.nextLine().split(": ")[1]);
            approvedStudents = Integer.parseInt(scanner.nextLine().split(": ")[1]);
            rejectedStudents = Integer.parseInt(scanner.nextLine().split(": ")[1]);
//            totalRooms = Integer.parseInt(scanner.nextLine().split(": ")[1]);
//            occupiedRooms = Integer.parseInt(scanner.nextLine().split(": ")[1]);
            scanner.nextLine();
            scanner.nextLine();
            otherIncomePerMonth = Double.parseDouble(scanner.nextLine().split(": ")[1]);
            staffSalaryPerMonth = Double.parseDouble(scanner.nextLine().split(": ")[1]);
            utilitiesPerMonth = Double.parseDouble(scanner.nextLine().split(": ")[1]);
            maintenancePerMonth = Double.parseDouble(scanner.nextLine().split(": ")[1]);
            scanner.close();

            // read the data from gri.txt
            Scanner s2 = new Scanner(new File("C:\\Users\\danie\\Documents\\NetBeansProjects\\HostelManagementSystem\\cgri.txt"));
            totalRooms = Integer.parseInt(s2.nextLine().split(": ")[1]);
            occupiedRooms = Integer.parseInt(s2.nextLine().split(": ")[1]);
            s2.close();

            // Test Code
            System.out.println("totalRentPerMonth: " + totalRentPerMonth);
            System.out.println("totalStudents: " + totalStudents);
            System.out.println("approvedStudents: " + approvedStudents);
            System.out.println("rejectedStudents: " + rejectedStudents);
            System.out.println("totalRooms: " + totalRooms);
            System.out.println("occupiedRooms: " + otherIncomePerMonth);
            System.out.println("otherIncomePerMonth: " + otherIncomePerMonth);
            System.out.println("staffSalaryPerMonth: " + staffSalaryPerMonth);
            System.out.println("utilitiesPerMonth: " + utilitiesPerMonth);
            System.out.println("maintenancePerMonth: " + maintenancePerMonth);

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // calculate the required values
        double averageRentPerStudent = totalRentPerMonth / totalStudents;

        double occupancyRate = (double) occupiedRooms / totalRooms * 100;
        // Format occupancy rate to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedOccupancyRate = df.format(occupancyRate);

        double totalRentPerYear = totalRentPerMonth * 12;
        double annualRevenue = totalRentPerYear * occupancyRate / 100;
        double totalRevenuePerMonth = totalRentPerMonth + otherIncomePerMonth;
        double totalCostPerMonth = staffSalaryPerMonth + utilitiesPerMonth + maintenancePerMonth;
        double netIncomePerMonth = totalRevenuePerMonth - totalCostPerMonth;

        // display the calculated values in the GUI
        txtTotalRentPerMonth.setText("RM " + String.valueOf(totalRentPerMonth));
        txtTotalStudents.setText(String.valueOf(totalStudents));
        txtApprovedStudents.setText(String.valueOf(approvedStudents));
        txtRejectedStudents.setText(String.valueOf(rejectedStudents));
        txtTotalRooms.setText(String.valueOf(totalRooms));
        txtOccupiedRooms.setText(String.valueOf(occupiedRooms));
        txtAverageRentPerStudent.setText("RM " + String.valueOf(averageRentPerStudent));
        txtOccupancyRate.setText(String.valueOf(formattedOccupancyRate) + "%");
        txtTotalRentYearEC.setText("RM " + String.valueOf(totalRentPerYear));
        txtAnnualRevenueEC.setText("RM " + String.valueOf(annualRevenue));
        txtNetIncomeEC.setText("RM " + String.valueOf(netIncomePerMonth));

        //locked the textfields
        txtTotalRentPerMonth.setEditable(false);
        txtTotalStudents.setEditable(false);
        txtApprovedStudents.setEditable(false);
        txtRejectedStudents.setEditable(false);
        txtTotalRooms.setEditable(false);
        txtOccupiedRooms.setEditable(false);
        txtAverageRentPerStudent.setEditable(false);
        txtTotalRentYearEC.setEditable(false);

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
        lblCRUDtitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMonthYear = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtRejectedStudents = new javax.swing.JTextField();
        txtTotalRooms = new javax.swing.JTextField();
        txtOccupiedRooms = new javax.swing.JTextField();
        txtTotalRentYearEC = new javax.swing.JTextField();
        txtTotalStudents = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtApprovedStudents = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtOccupancyRate = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtAnnualRevenueEC = new javax.swing.JTextField();
        txtNetIncomeEC = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        lblInvoiceNo = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lblAdminName = new javax.swing.JLabel();
        lblcreatedDateMR = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblAdminAddress = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMonthlyReport = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel53 = new javax.swing.JLabel();
        txtAverageRentPerStudent = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtTotalRentPerMonth = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        BackBtn = new javax.swing.JButton();
        btnPrintReportIR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 660));
        setName("AdminGenerateReport"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(199, 213, 224));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 820));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 820));
        jPanel1.setLayout(null);

        lblCRUDtitle.setFont(new java.awt.Font("Kanit SemiBold", 0, 36)); // NOI18N
        lblCRUDtitle.setForeground(new java.awt.Color(255, 102, 102));
        lblCRUDtitle.setText("HOSTEL");
        lblCRUDtitle.setName("AdminHRI"); // NOI18N
        jPanel1.add(lblCRUDtitle);
        lblCRUDtitle.setBounds(220, 50, 130, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\danie\\Documents\\NetBeansProjects\\HostelManagementSystem\\XYZ_small.png")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 30, 190, 80);

        lblMonthYear.setFont(new java.awt.Font("Kanit SemiBold", 0, 48)); // NOI18N
        lblMonthYear.setForeground(new java.awt.Color(72, 134, 183));
        lblMonthYear.setText("Month Year");
        lblMonthYear.setName("AdminHRI"); // NOI18N
        jPanel1.add(lblMonthYear);
        lblMonthYear.setBounds(535, 130, 260, 60);

        jPanel3.setBackground(new java.awt.Color(32, 82, 149));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(33, 42, 62));
        jPanel3.setLayout(null);

        jLabel43.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("All Hostel Rooms' Statistics");
        jPanel3.add(jLabel43);
        jLabel43.setBounds(475, 10, 310, 23);
        jLabel43.getAccessibleContext().setAccessibleName("");

        jLabel47.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Student Hostel Room Applications");
        jPanel3.add(jLabel47);
        jLabel47.setBounds(30, 10, 360, 23);

        jLabel45.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Estimated Calculations");
        jPanel3.add(jLabel45);
        jLabel45.setBounds(880, 10, 240, 23);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 240, 1150, 50);

        jPanel2.setBackground(new java.awt.Color(155, 164, 181));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel2.setLayout(null);

        txtRejectedStudents.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRejectedStudents.setToolTipText("Enter Your Usernme");
        txtRejectedStudents.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtRejectedStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRejectedStudentsActionPerformed(evt);
            }
        });
        jPanel2.add(txtRejectedStudents);
        txtRejectedStudents.setBounds(60, 240, 190, 40);

        txtTotalRooms.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtTotalRooms.setToolTipText("Enter Your Usernme");
        txtTotalRooms.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTotalRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalRoomsActionPerformed(evt);
            }
        });
        jPanel2.add(txtTotalRooms);
        txtTotalRooms.setBounds(510, 60, 190, 40);

        txtOccupiedRooms.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtOccupiedRooms.setToolTipText("Enter Your Usernme");
        txtOccupiedRooms.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtOccupiedRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOccupiedRoomsActionPerformed(evt);
            }
        });
        jPanel2.add(txtOccupiedRooms);
        txtOccupiedRooms.setBounds(510, 150, 190, 40);

        txtTotalRentYearEC.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtTotalRentYearEC.setToolTipText("Enter Your Usernme");
        txtTotalRentYearEC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTotalRentYearEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalRentYearECActionPerformed(evt);
            }
        });
        jPanel2.add(txtTotalRentYearEC);
        txtTotalRentYearEC.setBounds(890, 60, 190, 40);

        txtTotalStudents.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtTotalStudents.setToolTipText("Enter Your Usernme");
        txtTotalStudents.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTotalStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalStudentsActionPerformed(evt);
            }
        });
        jPanel2.add(txtTotalStudents);
        txtTotalStudents.setBounds(60, 60, 190, 40);

        jLabel44.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Total Rejected Applications");
        jPanel2.add(jLabel44);
        jLabel44.setBounds(60, 200, 320, 30);

        txtApprovedStudents.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtApprovedStudents.setToolTipText("Enter Your Usernme");
        txtApprovedStudents.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApprovedStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApprovedStudentsActionPerformed(evt);
            }
        });
        jPanel2.add(txtApprovedStudents);
        txtApprovedStudents.setBounds(60, 150, 190, 40);

        jLabel46.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Total Approved Applications");
        jPanel2.add(jLabel46);
        jLabel46.setBounds(60, 110, 320, 30);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(420, -40, 20, 260);

        jLabel48.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Occupancy Rate");
        jPanel2.add(jLabel48);
        jLabel48.setBounds(510, 200, 320, 30);

        jLabel49.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Total Number of Appliciants");
        jPanel2.add(jLabel49);
        jLabel49.setBounds(60, 20, 320, 30);

        jLabel50.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("~Total Rent Per Year");
        jPanel2.add(jLabel50);
        jLabel50.setBounds(890, 20, 220, 30);

        jLabel52.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Total Occupied Rooms");
        jPanel2.add(jLabel52);
        jLabel52.setBounds(510, 110, 320, 30);

        jLabel54.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Total Hostel Rooms");
        jPanel2.add(jLabel54);
        jLabel54.setBounds(510, 20, 320, 30);

        txtOccupancyRate.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtOccupancyRate.setToolTipText("Enter Your Usernme");
        txtOccupancyRate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtOccupancyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOccupancyRateActionPerformed(evt);
            }
        });
        jPanel2.add(txtOccupancyRate);
        txtOccupancyRate.setBounds(510, 240, 190, 40);

        jLabel55.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("~Annual Revenue");
        jPanel2.add(jLabel55);
        jLabel55.setBounds(890, 110, 210, 30);

        txtAnnualRevenueEC.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtAnnualRevenueEC.setToolTipText("Enter Your Usernme");
        txtAnnualRevenueEC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAnnualRevenueEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnnualRevenueECActionPerformed(evt);
            }
        });
        jPanel2.add(txtAnnualRevenueEC);
        txtAnnualRevenueEC.setBounds(890, 150, 190, 40);

        txtNetIncomeEC.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtNetIncomeEC.setToolTipText("Enter Your Usernme");
        txtNetIncomeEC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNetIncomeEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNetIncomeECActionPerformed(evt);
            }
        });
        jPanel2.add(txtNetIncomeEC);
        txtNetIncomeEC.setBounds(890, 240, 190, 40);

        jLabel56.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("~Net Income /Month");
        jPanel2.add(jLabel56);
        jLabel56.setBounds(890, 200, 230, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 310, 1150, 310);

        lblInvoiceNo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblInvoiceNo.setForeground(new java.awt.Color(57, 72, 103));
        lblInvoiceNo.setText("1");
        lblInvoiceNo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblInvoiceNoPropertyChange(evt);
            }
        });
        jPanel1.add(lblInvoiceNo);
        lblInvoiceNo.setBounds(180, 150, 40, 23);

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(57, 72, 103));
        jLabel39.setText("Invoice No. :");
        jPanel1.add(jLabel39);
        jLabel39.setBounds(40, 150, 140, 23);

        jLabel40.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(57, 72, 103));
        jLabel40.setText("Admin Name :");
        jPanel1.add(jLabel40);
        jLabel40.setBounds(28, 160, 150, 40);

        lblAdminName.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblAdminName.setForeground(new java.awt.Color(57, 72, 103));
        lblAdminName.setText("Daniel Poh");
        lblAdminName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblAdminNamePropertyChange(evt);
            }
        });
        jPanel1.add(lblAdminName);
        lblAdminName.setBounds(180, 160, 120, 40);

        lblcreatedDateMR.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblcreatedDateMR.setForeground(new java.awt.Color(57, 72, 103));
        lblcreatedDateMR.setText("createdDate");
        lblcreatedDateMR.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblcreatedDateMRPropertyChange(evt);
            }
        });
        jPanel1.add(lblcreatedDateMR);
        lblcreatedDateMR.setBounds(180, 180, 240, 40);

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(57, 72, 103));
        jLabel41.setText("Created Date :");
        jPanel1.add(jLabel41);
        jLabel41.setBounds(25, 180, 150, 40);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 140, 370, 80);

        jPanel5.setBackground(new java.awt.Color(141, 212, 247));
        jPanel5.setBorder(new javax.swing.border.MatteBorder(null));

        lblAdminAddress.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jPanel5.add(lblAdminAddress);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(920, 40, 250, 140);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 298, 1150, 10);

        lblMonthlyReport.setFont(new java.awt.Font("Kanit SemiBold", 0, 60)); // NOI18N
        lblMonthlyReport.setForeground(new java.awt.Color(42, 71, 94));
        lblMonthlyReport.setText("Monthly Report");
        lblMonthlyReport.setName("AdminHRI"); // NOI18N
        jPanel1.add(lblMonthlyReport);
        lblMonthlyReport.setBounds(410, 70, 440, 60);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(20, 130, 1150, 10);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(20, 228, 1150, 20);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(20, 630, 1150, 2);

        jLabel53.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(72, 134, 183));
        jLabel53.setText("Average Room Price (RM):");
        jPanel1.add(jLabel53);
        jLabel53.setBounds(680, 650, 340, 30);

        txtAverageRentPerStudent.setBackground(new java.awt.Color(255, 255, 102));
        txtAverageRentPerStudent.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtAverageRentPerStudent.setForeground(new java.awt.Color(255, 51, 51));
        txtAverageRentPerStudent.setToolTipText("Enter Your Usernme");
        txtAverageRentPerStudent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAverageRentPerStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAverageRentPerStudentActionPerformed(evt);
            }
        });
        jPanel1.add(txtAverageRentPerStudent);
        txtAverageRentPerStudent.setBounds(970, 650, 190, 40);

        jLabel51.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(72, 134, 183));
        jLabel51.setText("Total Monthly Income (RM):");
        jPanel1.add(jLabel51);
        jLabel51.setBounds(670, 710, 300, 30);

        txtTotalRentPerMonth.setBackground(new java.awt.Color(254, 139, 139));
        txtTotalRentPerMonth.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtTotalRentPerMonth.setForeground(new java.awt.Color(255, 0, 0));
        txtTotalRentPerMonth.setToolTipText("Enter Your Usernme");
        txtTotalRentPerMonth.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTotalRentPerMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalRentPerMonthActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotalRentPerMonth);
        txtTotalRentPerMonth.setBounds(970, 710, 190, 40);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(20, 635, 1150, 2);

        BackBtn.setFont(new java.awt.Font("Kanit Medium", 2, 36)); // NOI18N
        BackBtn.setText("Back");
        BackBtn.setToolTipText("");
        BackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        jPanel1.add(BackBtn);
        BackBtn.setBounds(30, 680, 200, 60);

        btnPrintReportIR.setFont(new java.awt.Font("Kanit Medium", 2, 36)); // NOI18N
        btnPrintReportIR.setText("Print Report");
        btnPrintReportIR.setToolTipText("");
        btnPrintReportIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintReportIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintReportIRActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrintReportIR);
        btnPrintReportIR.setBounds(250, 680, 320, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalRentYearECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalRentYearECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalRentYearECActionPerformed

    private void txtTotalRentPerMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalRentPerMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalRentPerMonthActionPerformed

    private void txtTotalStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalStudentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalStudentsActionPerformed

    private void txtApprovedStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApprovedStudentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApprovedStudentsActionPerformed

    private void txtRejectedStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRejectedStudentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRejectedStudentsActionPerformed

    private void txtTotalRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalRoomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalRoomsActionPerformed

    private void txtOccupiedRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOccupiedRoomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOccupiedRoomsActionPerformed

    private void txtAverageRentPerStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAverageRentPerStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAverageRentPerStudentActionPerformed

    private void lblInvoiceNoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblInvoiceNoPropertyChange
        // Define a variable to store the current invoice number
        int currentInvoiceNo = 0;

        // Generate a new invoice
        // ...
        // Increment the current invoice number for the next invoice
        currentInvoiceNo++;

        // Set the label text to the new invoice number
        lblInvoiceNo.setText(String.valueOf(currentInvoiceNo));
    }//GEN-LAST:event_lblInvoiceNoPropertyChange

    private void lblAdminNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblAdminNamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAdminNamePropertyChange

    private void lblcreatedDateMRPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblcreatedDateMRPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblcreatedDateMRPropertyChange

    private void txtOccupancyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOccupancyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOccupancyRateActionPerformed

    private void txtAnnualRevenueECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnnualRevenueECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnnualRevenueECActionPerformed

    private void txtNetIncomeECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNetIncomeECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNetIncomeECActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        AdminGenerateReports agr = new AdminGenerateReports(userSession);
        agr.setLocationRelativeTo(null);
        agr.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void btnPrintReportIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintReportIRActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.24, 0.24);

                jPanel1.paint(g2);

                return Printable.PAGE_EXISTS;

            }
        });

        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to print?", "Print Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            boolean ok = job.printDialog();
            if (ok) {
                try {
                    job.print();
                    int invoiceNo = Integer.parseInt(lblInvoiceNo.getText()) + 1;
                    lblInvoiceNo.setText(Integer.toString(invoiceNo));
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(null, "Error printing report: " + ex.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Printing cancelled", "Print Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnPrintReportIRActionPerformed

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
            java.util.logging.Logger.getLogger(generateIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generateIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generateIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generateIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserSession userSession = new UserSession("admin"); // Create UserSession instance with username
                new generateIR(userSession).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton btnPrintReportIR;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblAdminAddress;
    public static javax.swing.JLabel lblAdminName;
    private javax.swing.JLabel lblCRUDtitle;
    public static javax.swing.JLabel lblInvoiceNo;
    private javax.swing.JLabel lblMonthYear;
    private javax.swing.JLabel lblMonthlyReport;
    public static javax.swing.JLabel lblcreatedDateMR;
    private javax.swing.JTextField txtAnnualRevenueEC;
    private javax.swing.JTextField txtApprovedStudents;
    private javax.swing.JTextField txtAverageRentPerStudent;
    private javax.swing.JTextField txtNetIncomeEC;
    private javax.swing.JTextField txtOccupancyRate;
    private javax.swing.JTextField txtOccupiedRooms;
    private javax.swing.JTextField txtRejectedStudents;
    private javax.swing.JTextField txtTotalRentPerMonth;
    private javax.swing.JTextField txtTotalRentYearEC;
    private javax.swing.JTextField txtTotalRooms;
    private javax.swing.JTextField txtTotalStudents;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hostelmanagementsystem.Admin;

import hostelmanagementsystem.Students.HostelApplicationForm;
import hostelmanagementsystem.Students.Menu1;
import hostelmanagementsystem.Students.StudentDashboard;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class StudentHostelRoomInfo extends javax.swing.JFrame {

    private UserSession userSession;
    /**
     * Creates new form StudentHostelRoomInfo
     */
    ImageIcon wi = new ImageIcon("thelogo.jpg");
    ImageIcon info = new ImageIcon("SHRI_info.png");

    public StudentHostelRoomInfo(UserSession userSession) throws FileNotFoundException {

        //Define User Session
        this.userSession = userSession;

        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //Window itself
        this.setSize(1210, 670);
        this.setIconImage(wi.getImage());
        this.setTitle("Student Hostel Room Information | XYZ Hostel");

        // Info Image Logo
        lblSHRInfo.setText("");
        lblSHRInfo.setIcon(info);

        // Window when close
        this.setDefaultCloseOperation(LandingPage.EXIT_ON_CLOSE);
        this.setVisible(false);

        // Select-able
        roomsTableStudent.setEnabled(true);

        // Set the selection mode of the JTable to single selection
        roomsTableStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Clear any previous selection
        roomsTableStudent.clearSelection();

        // Display roomTableStudent (JTable) by default
        displayRoomData();

        roomsTableStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check for double-click events
                if (e.getClickCount() == 2) {
                    // Get the selected row index
                    int rowIndex = roomsTableStudent.getSelectedRow();

                    // Check if the selected row index is within the valid range
                    if (rowIndex >= 0 && rowIndex < roomsTableStudent.getRowCount()) {
                        // Get the data from the selected row
                        String roomNo = (String) roomsTableStudent.getValueAt(rowIndex, 0);
                        String roomType = (String) roomsTableStudent.getValueAt(rowIndex, 1);
                        String roomCapacity = (String) roomsTableStudent.getValueAt(rowIndex, 2);
                        String roomAvailability = (String) roomsTableStudent.getValueAt(rowIndex, 3);
                        String roomPrice = (String) roomsTableStudent.getValueAt(rowIndex, 4);

                        // Create a JFrame to display the details
                        JFrame frame = new JFrame();

                        frame.setTitle("Room Details");
                        frame.setSize(600, 400);
                        frame.setLocationRelativeTo(null);
                        frame.setResizable(false);
                        frame.setIconImage(wi.getImage());
                        frame.setTitle("Hostel Room Info Details | XYZ Hostel");

                        // Define an array of room descriptions
                        String[] roomDescriptions = {"This room has a great view.",
                            "This room is spacious.",
                            "This room is big enough for 6 people.",
                            "This room has fast Wi-Fi.",
                            "This room is located in a quiet area.",
                            "This room has soft beds.."};
                        // Generate a random index to select a room description from the array
                        int randomIndex = (int) (Math.random() * roomDescriptions.length);
                        String roomDescription = roomDescriptions[randomIndex];

                        // Create a JPanel to hold the details
                        Font font = new Font("Dubai", Font.PLAIN, 18);
                        JLabel roomNoLabel = new JLabel("Room No: ");
                        roomNoLabel.setFont(font);

                        JLabel roomTypeLabel = new JLabel("Room Type: ");
                        roomTypeLabel.setFont(font);

                        JLabel roomCapacityLabel = new JLabel("Room Capacity: ");
                        roomCapacityLabel.setFont(font);

                        JLabel roomAvailabilityLabel = new JLabel("Room Availability: ");
                        roomAvailabilityLabel.setFont(font);

                        JLabel roomPriceLabel = new JLabel("Room Price: ");
                        roomPriceLabel.setFont(font);

                        JLabel roomDescriptionLabel = new JLabel("Room Description: ");
                        JTextArea roomDescriptionArea = new JTextArea(roomDescription);
                        roomDescriptionArea.setEditable(false);
                        roomDescriptionArea.setEnabled(false);
                        roomDescriptionArea.setWrapStyleWord(true);
                        roomDescriptionArea.setLineWrap(true);
                        roomDescriptionLabel.setFont(font);

                        JPanel panel = new JPanel(new GridLayout(10, 10, 10, 10));
                        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        panel.add(roomNoLabel);
                        panel.add(new JLabel(roomNo));
                        panel.add(roomTypeLabel);
                        panel.add(new JLabel(roomType));
                        panel.add(roomCapacityLabel);
                        panel.add(new JLabel(roomCapacity));
                        panel.add(roomAvailabilityLabel);
                        panel.add(new JLabel(roomAvailability));
                        panel.add(roomPriceLabel);
                        panel.add(new JLabel(roomPrice));
                        panel.add(roomDescriptionLabel);
                        panel.add(new JTextArea(roomDescription));

                        // Add the panel to the frame and show the window
                        frame.add(panel);
                        frame.setVisible(true);

                        // Create a JScrollPane and add the panel to it
                        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

                        // Add the scroll pane to the frame and show the window
                        frame.add(scrollPane);
                        frame.setVisible(true);

                    }
                }
            }
        });

    }

    private void displayRoomData() {
        try {
            DefaultTableModel model = (DefaultTableModel) roomsTableStudent.getModel();
            model.setRowCount(0);
            handleFiles file = new handleFiles("room.txt");
            Object[] fileData = file.reader();

            for (int i = 0; i < fileData.length; i++) {
                String line = fileData[i].toString().trim();
                String[] dataRow = line.split(", ");
                if (i == 0) {
                    model.setColumnIdentifiers(dataRow);
                } else {
                    model.addRow(dataRow);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentHostelRoomInfo.class.getName()).log(Level.SEVERE, null, ex);
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
        lblCRUDtitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsTableStudent = new javax.swing.JTable();
        btnMyDashboard = new javax.swing.JButton();
        btnExitSHRI = new javax.swing.JButton();
        btnBackSHRI = new javax.swing.JButton();
        btnStudentHostelApplication = new javax.swing.JButton();
        lblSHRInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 670));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 192, 244));
        jPanel1.setMinimumSize(new java.awt.Dimension(1210, 670));
        jPanel1.setPreferredSize(new java.awt.Dimension(1210, 670));
        jPanel1.setLayout(null);

        lblCRUDtitle.setFont(new java.awt.Font("Kanit SemiBold", 0, 48)); // NOI18N
        lblCRUDtitle.setForeground(new java.awt.Color(255, 255, 255));
        lblCRUDtitle.setText("Student Hostel Room Information ");
        lblCRUDtitle.setName("AdminHRI"); // NOI18N
        jPanel1.add(lblCRUDtitle);
        lblCRUDtitle.setBounds(40, 40, 760, 40);

        roomsTableStudent.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        roomsTableStudent.setForeground(new java.awt.Color(27, 40, 56));
        roomsTableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No.", "Room Type", "Room Status", "Room Capacity", "Room Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomsTableStudent.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        roomsTableStudent.setColumnSelectionAllowed(true);
        roomsTableStudent.setEnabled(false);
        roomsTableStudent.setRowHeight(30);
        roomsTableStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsTableStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomsTableStudent);
        roomsTableStudent.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 850, 490);

        btnMyDashboard.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnMyDashboard.setText("My Dashboard");
        btnMyDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMyDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyDashboardActionPerformed(evt);
            }
        });
        jPanel1.add(btnMyDashboard);
        btnMyDashboard.setBounds(930, 420, 230, 40);

        btnExitSHRI.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnExitSHRI.setText("Exit Now");
        btnExitSHRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExitSHRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitSHRIActionPerformed(evt);
            }
        });
        jPanel1.add(btnExitSHRI);
        btnExitSHRI.setBounds(1040, 40, 130, 40);

        btnBackSHRI.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnBackSHRI.setText("Back");
        btnBackSHRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackSHRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackSHRIActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackSHRI);
        btnBackSHRI.setBounds(880, 40, 130, 40);

        btnStudentHostelApplication.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnStudentHostelApplication.setText("Hostel Application");
        btnStudentHostelApplication.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudentHostelApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentHostelApplicationActionPerformed(evt);
            }
        });
        jPanel1.add(btnStudentHostelApplication);
        btnStudentHostelApplication.setBounds(930, 330, 230, 40);
        jPanel1.add(lblSHRInfo);
        lblSHRInfo.setBounds(970, 100, 240, 200);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1220, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomsTableStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsTableStudentMouseClicked

    }//GEN-LAST:event_roomsTableStudentMouseClicked

    private void btnMyDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyDashboardActionPerformed
        StudentDashboard sd = new StudentDashboard(userSession);
        sd.setLocationRelativeTo(null);
        sd.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMyDashboardActionPerformed

    private void btnExitSHRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitSHRIActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitSHRIActionPerformed

    private void btnBackSHRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackSHRIActionPerformed
        StudentDashboard sd = new StudentDashboard(userSession);
        sd.setLocationRelativeTo(null);
        sd.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackSHRIActionPerformed

    private void btnStudentHostelApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentHostelApplicationActionPerformed
        HostelApplicationForm haf = new HostelApplicationForm(userSession);
        haf.setLocationRelativeTo(null);
        haf.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnStudentHostelApplicationActionPerformed

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
            java.util.logging.Logger.getLogger(StudentHostelRoomInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHostelRoomInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHostelRoomInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHostelRoomInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserSession userSession = new UserSession("admin"); // Create UserSession instance with username
                try {
                    new StudentHostelRoomInfo(userSession).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(StudentHostelRoomInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackSHRI;
    private javax.swing.JButton btnExitSHRI;
    private javax.swing.JButton btnMyDashboard;
    private javax.swing.JButton btnStudentHostelApplication;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCRUDtitle;
    private javax.swing.JLabel lblSHRInfo;
    private javax.swing.JTable roomsTableStudent;
    // End of variables declaration//GEN-END:variables
}

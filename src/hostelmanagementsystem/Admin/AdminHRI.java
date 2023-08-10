/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hostelmanagementsystem.Admin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Daniel
 */
public class AdminHRI extends javax.swing.JFrame {

    ImageIcon wi = new ImageIcon("thelogo.jpg");
    private UserSession userSession;
    private List<RoomType> roomTypes; // Declare roomTypes as a class member
    private DataImporter dataImporter;

    /**
     * Creates new form AdminHRI
     */
    public AdminHRI(UserSession userSession) throws FileNotFoundException {

        //Define User Session
        this.userSession = userSession;
        
        // Define import data
        dataImporter = new DataImporter("room.txt");

        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        // In case ssetLocationRelativeTo(null) is broken.

        // Call the method to populate the combo box (Polymorphism)
        populateComboBox();

        //Window itself
        this.setSize(1194, 650);
        this.setIconImage(wi.getImage());
        this.setTitle("Admin CRUD HRI | XYZ Hostel Management");

        // Window when close
        this.setDefaultCloseOperation(LandingPage.EXIT_ON_CLOSE);
        this.setVisible(false);

        //importing the data from the text-file to here.
        importData();

        // Delete Panel Listener
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                // Enable the JTable
                roomsTable.setEnabled(true);

                // Set the selection mode of the JTable to single selection
                roomsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        });

        roomsTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
                    int selectedRow = roomsTable.getSelectedRow();
                    if (selectedRow != -1) {
                        model.removeRow(selectedRow);
                        saveRoomsDataToFile(model);
                    }
                }
            }
        });

        // Make <--SELECT--> unable to click
        cbRoomType.setSelectedIndex(-1); // Unselect the current selection
        cbRoomType.getModel().setSelectedItem("<--SELECT-->"); // Select the default "<--SELECT-->" item
//        cbRoomType.setEnabled(false); // Disable the JComboBox

        cbRoomStatus.setSelectedIndex(-1); // Unselect the current selection
        cbRoomStatus.getModel().setSelectedItem("<--SELECT-->"); // Select the default "<--SELECT-->" item
//        cbRoomStatus.setEnabled(false); // Disable the JComboBox

        cbRoomTypeUpdate.setSelectedIndex(-1); // Unselect the current selection
        cbRoomTypeUpdate.getModel().setSelectedItem("<--SELECT-->"); // Select the default "<--SELECT-->" item
//        cbRoomTypeUpdate.setEnabled(false); // Disable the JComboBox

        cbRoomStatusUpdate.setSelectedIndex(-1); // Unselect the current selection
        cbRoomStatusUpdate.getModel().setSelectedItem("<--SELECT-->"); // Select the default "<--SELECT-->" item
//        cbRoomStatusUpdate.setEnabled(false); // Disable the JComboBox

    }

    private void saveRoomsDataToFile(DefaultTableModel model) {
        try ( PrintWriter writer = new PrintWriter(new FileWriter("room.txt"))) {
            writer.println("Room No., Room Type, Room Capacity, Room Status, Room Price");
            for (int row = 0; row < model.getRowCount(); row++) {
                String[] rowData = new String[model.getColumnCount()];
                for (int column = 0; column < model.getColumnCount(); column++) {
                    rowData[column] = model.getValueAt(row, column).toString();
                }
                writer.println(String.join(", ", rowData));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public final void importData() throws FileNotFoundException {
        String roomNo = dataImporter.generateRoomNumber();
        txtRoomNo.setText(roomNo);
        dataImporter.importData(roomsTable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        popupMenu1 = new java.awt.PopupMenu();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        Create = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCreateRoom = new javax.swing.JButton();
        lblCRUDtitle5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRoomPrice = new javax.swing.JTextField();
        txtRoomNo = new javax.swing.JTextField();
        txtRoomCapacity = new javax.swing.JTextField();
        cbRoomStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbRoomType = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        btnClear1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSortingTableData = new javax.swing.JButton();
        lblCRUDtitle2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRoomNoDisplay = new javax.swing.JTextField();
        btnClearDisplay = new javax.swing.JButton();
        btnResetDisplay = new javax.swing.JButton();
        btnSearchDisplay = new javax.swing.JButton();
        btnViewAllRoomInfo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnUpdateRoomsTable = new javax.swing.JButton();
        lblCRUDtitle3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRoomNoUpdate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbRoomTypeUpdate = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbRoomStatusUpdate = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtRoomCapacityUpdate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtRoomPriceUpdate = new javax.swing.JTextField();
        btnResetUpdate = new javax.swing.JButton();
        btnClearUpdate = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblCRUDtitle4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnClearRemove = new javax.swing.JButton();
        btnResetRemove = new javax.swing.JButton();
        btnSelectRow = new javax.swing.JButton();
        btnDeleteRow = new javax.swing.JButton();
        btnViewAllDataRemove = new javax.swing.JButton();
        btnSelectedDelete = new javax.swing.JButton();
        lblCRUDtitle = new javax.swing.JLabel();
        btnQuitCRUD = new javax.swing.JButton();
        btnBackCRUD = new javax.swing.JButton();
        btnNextCRUD = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.gray);
        getContentPane().setLayout(null);

        jPanel5.setBackground(new java.awt.Color(102, 192, 244));
        jPanel5.setForeground(new java.awt.Color(102, 192, 244));
        jPanel5.setMinimumSize(new java.awt.Dimension(1194, 650));
        jPanel5.setPreferredSize(new java.awt.Dimension(1194, 650));
        jPanel5.setLayout(null);

        roomsTable.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        roomsTable.setForeground(new java.awt.Color(27, 40, 56));
        roomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No.", "Room Type", "Room Status", "Capacity", "Room Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomsTable.setToolTipText("This table will display all the room info based on the admin inout.");
        roomsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        roomsTable.setEnabled(false);
        roomsTable.setRowHeight(30);
        roomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomsTable);
        if (roomsTable.getColumnModel().getColumnCount() > 0) {
            roomsTable.getColumnModel().getColumn(0).setResizable(false);
            roomsTable.getColumnModel().getColumn(1).setResizable(false);
            roomsTable.getColumnModel().getColumn(2).setResizable(false);
            roomsTable.getColumnModel().getColumn(3).setResizable(false);
            roomsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(530, 110, 640, 490);

        Create.setBackground(new java.awt.Color(42, 71, 94));
        Create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(42, 71, 94));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(null);

        btnCreateRoom.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnCreateRoom.setText("Create");
        btnCreateRoom.setToolTipText("Submit To Make It Happen");
        btnCreateRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRoomActionPerformed(evt);
            }
        });
        btnCreateRoom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCreateRoomKeyPressed(evt);
            }
        });
        jPanel1.add(btnCreateRoom);
        btnCreateRoom.setBounds(320, 400, 113, 47);

        lblCRUDtitle5.setFont(new java.awt.Font("Kanit SemiBold", 0, 36)); // NOI18N
        lblCRUDtitle5.setForeground(new java.awt.Color(255, 255, 255));
        lblCRUDtitle5.setText("Add Room Info");
        lblCRUDtitle5.setName("AdminHRI"); // NOI18N
        jPanel1.add(lblCRUDtitle5);
        lblCRUDtitle5.setBounds(50, 40, 310, 40);

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Room Price:");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 340, 100, 30);

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Room No:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 110, 100, 30);

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Room Availability:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 220, 150, 30);

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Room Capacity:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 280, 130, 30);

        txtRoomPrice.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRoomPrice.setText("Enter Room Price");
        txtRoomPrice.setToolTipText("Set Room Price");
        txtRoomPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRoomPriceMouseClicked(evt);
            }
        });
        txtRoomPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtRoomPrice);
        txtRoomPrice.setBounds(200, 340, 160, 30);

        txtRoomNo.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRoomNo.setToolTipText("Enter Room No.");
        txtRoomNo.setMinimumSize(new java.awt.Dimension(1020, 855));
        txtRoomNo.setPreferredSize(new java.awt.Dimension(1020, 855));
        txtRoomNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomNoActionPerformed(evt);
            }
        });
        jPanel1.add(txtRoomNo);
        txtRoomNo.setBounds(200, 110, 160, 30);

        txtRoomCapacity.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRoomCapacity.setText("Enter Capacity");
        txtRoomCapacity.setToolTipText("Number of Person");
        txtRoomCapacity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRoomCapacityMouseClicked(evt);
            }
        });
        txtRoomCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomCapacityActionPerformed(evt);
            }
        });
        jPanel1.add(txtRoomCapacity);
        txtRoomCapacity.setBounds(200, 280, 160, 30);

        cbRoomStatus.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cbRoomStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- SELECT -->", "Available", "Unavailable" }));
        cbRoomStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomStatusActionPerformed(evt);
            }
        });
        jPanel1.add(cbRoomStatus);
        cbRoomStatus.setBounds(200, 220, 160, 42);

        jLabel7.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Room Type:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 160, 100, 30);

        cbRoomType.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cbRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- SELECT -->", "Dormitory", "Shared", "Private" }));
        cbRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomTypeActionPerformed(evt);
            }
        });
        jPanel1.add(cbRoomType);
        cbRoomType.setBounds(200, 160, 160, 42);

        btnReset.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setToolTipText("Clear Everything");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset);
        btnReset.setBounds(40, 400, 113, 47);

        btnClear1.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnClear1.setText("Clear");
        btnClear1.setToolTipText("Only For Room Info.");
        btnClear1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear1);
        btnClear1.setBounds(180, 400, 113, 47);

        Create.addTab("Create", jPanel1);

        jPanel2.setBackground(new java.awt.Color(42, 71, 94));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);

        btnSortingTableData.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnSortingTableData.setText("Sort Hostel Room Table Data");
        btnSortingTableData.setToolTipText("Once you click it, you will see a dropdown arrow on roomsTable.");
        btnSortingTableData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSortingTableData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortingTableDataActionPerformed(evt);
            }
        });
        jPanel2.add(btnSortingTableData);
        btnSortingTableData.setBounds(30, 360, 390, 60);

        lblCRUDtitle2.setFont(new java.awt.Font("Kanit SemiBold", 0, 36)); // NOI18N
        lblCRUDtitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblCRUDtitle2.setText("Display Room Info");
        lblCRUDtitle2.setName("AdminHRI"); // NOI18N
        jPanel2.add(lblCRUDtitle2);
        lblCRUDtitle2.setBounds(50, 40, 310, 40);

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Room No:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(50, 120, 100, 30);

        txtRoomNoDisplay.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRoomNoDisplay.setText("Enter Room No.");
        txtRoomNoDisplay.setToolTipText("Enter Room Number");
        txtRoomNoDisplay.setMinimumSize(new java.awt.Dimension(1020, 855));
        txtRoomNoDisplay.setPreferredSize(new java.awt.Dimension(1020, 855));
        txtRoomNoDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRoomNoDisplayMouseClicked(evt);
            }
        });
        txtRoomNoDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomNoDisplayActionPerformed(evt);
            }
        });
        jPanel2.add(txtRoomNoDisplay);
        txtRoomNoDisplay.setBounds(220, 120, 160, 30);

        btnClearDisplay.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnClearDisplay.setText("Clear");
        btnClearDisplay.setToolTipText("Only For Room Info.");
        btnClearDisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearDisplayActionPerformed(evt);
            }
        });
        jPanel2.add(btnClearDisplay);
        btnClearDisplay.setBounds(170, 190, 113, 47);

        btnResetDisplay.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnResetDisplay.setText("Reset");
        btnResetDisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDisplayActionPerformed(evt);
            }
        });
        jPanel2.add(btnResetDisplay);
        btnResetDisplay.setBounds(30, 190, 113, 47);

        btnSearchDisplay.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnSearchDisplay.setText("Search");
        btnSearchDisplay.setToolTipText("It will start finding the room for you.");
        btnSearchDisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDisplayActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearchDisplay);
        btnSearchDisplay.setBounds(310, 190, 113, 47);

        btnViewAllRoomInfo.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnViewAllRoomInfo.setText("View All Hostel Room Information");
        btnViewAllRoomInfo.setToolTipText("All The Info Will Display On The Table");
        btnViewAllRoomInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAllRoomInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllRoomInfoActionPerformed(evt);
            }
        });
        jPanel2.add(btnViewAllRoomInfo);
        btnViewAllRoomInfo.setBounds(30, 270, 390, 60);

        Create.addTab("Read", jPanel2);

        jPanel3.setBackground(new java.awt.Color(42, 71, 94));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(null);

        btnUpdateRoomsTable.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnUpdateRoomsTable.setText("Update");
        btnUpdateRoomsTable.setToolTipText("It will update accordingly based on the room you want.");
        btnUpdateRoomsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRoomsTableActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdateRoomsTable);
        btnUpdateRoomsTable.setBounds(320, 400, 113, 50);

        lblCRUDtitle3.setFont(new java.awt.Font("Kanit SemiBold", 0, 36)); // NOI18N
        lblCRUDtitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblCRUDtitle3.setText("Modify Room Info");
        lblCRUDtitle3.setName("AdminHRI"); // NOI18N
        jPanel3.add(lblCRUDtitle3);
        lblCRUDtitle3.setBounds(50, 40, 330, 40);

        jLabel9.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Room No:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 110, 100, 30);

        txtRoomNoUpdate.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRoomNoUpdate.setText("Enter Room No.");
        txtRoomNoUpdate.setToolTipText("Enter Room Number");
        txtRoomNoUpdate.setMinimumSize(new java.awt.Dimension(1020, 855));
        txtRoomNoUpdate.setPreferredSize(new java.awt.Dimension(1020, 855));
        txtRoomNoUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRoomNoUpdateMouseClicked(evt);
            }
        });
        txtRoomNoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomNoUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(txtRoomNoUpdate);
        txtRoomNoUpdate.setBounds(200, 110, 160, 30);

        jLabel10.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Room Type:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(30, 160, 100, 30);

        cbRoomTypeUpdate.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cbRoomTypeUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- SELECT -->", "Dormitory", "Shared", "Private" }));
        cbRoomTypeUpdate.setToolTipText("Choose Room Type");
        cbRoomTypeUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomTypeUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(cbRoomTypeUpdate);
        cbRoomTypeUpdate.setBounds(200, 160, 160, 42);

        jLabel11.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Room Availability:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(30, 220, 150, 30);

        cbRoomStatusUpdate.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cbRoomStatusUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- SELECT -->", "Available", "Unavailable" }));
        cbRoomStatusUpdate.setToolTipText("Choose Room Status");
        cbRoomStatusUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomStatusUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(cbRoomStatusUpdate);
        cbRoomStatusUpdate.setBounds(200, 220, 160, 42);

        jLabel12.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Room Capacity:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(30, 280, 130, 30);

        txtRoomCapacityUpdate.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRoomCapacityUpdate.setText("Enter Capacity");
        txtRoomCapacityUpdate.setToolTipText("Number of Person In The Room.");
        txtRoomCapacityUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRoomCapacityUpdateMouseClicked(evt);
            }
        });
        jPanel3.add(txtRoomCapacityUpdate);
        txtRoomCapacityUpdate.setBounds(200, 280, 160, 30);

        jLabel13.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Room Price:");
        jLabel13.setToolTipText("");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(30, 340, 100, 30);

        txtRoomPriceUpdate.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        txtRoomPriceUpdate.setText("Set Room Price");
        txtRoomPriceUpdate.setToolTipText("Set Room Price For Any Room.");
        txtRoomPriceUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRoomPriceUpdateMouseClicked(evt);
            }
        });
        txtRoomPriceUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomPriceUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(txtRoomPriceUpdate);
        txtRoomPriceUpdate.setBounds(200, 340, 160, 30);

        btnResetUpdate.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnResetUpdate.setText("Reset");
        btnResetUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnResetUpdate);
        btnResetUpdate.setBounds(40, 400, 113, 47);

        btnClearUpdate.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnClearUpdate.setText("Clear");
        btnClearUpdate.setToolTipText("Only For Room Info.");
        btnClearUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnClearUpdate);
        btnClearUpdate.setBounds(180, 400, 113, 47);

        Create.addTab("Update", jPanel3);

        jPanel4.setBackground(new java.awt.Color(42, 71, 94));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(null);

        lblCRUDtitle4.setFont(new java.awt.Font("Kanit SemiBold", 0, 36)); // NOI18N
        lblCRUDtitle4.setForeground(new java.awt.Color(255, 255, 255));
        lblCRUDtitle4.setText("Remove Room Info");
        lblCRUDtitle4.setName("AdminHRI"); // NOI18N
        jPanel4.add(lblCRUDtitle4);
        lblCRUDtitle4.setBounds(50, 40, 360, 40);

        jPanel6.setBackground(new java.awt.Color(27, 40, 56));
        jPanel6.setForeground(new java.awt.Color(23, 26, 33));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(null);

        btnClearRemove.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnClearRemove.setText("Clear Row");
        btnClearRemove.setToolTipText("Clean Single Selection of a row.");
        btnClearRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearRemoveActionPerformed(evt);
            }
        });
        jPanel6.add(btnClearRemove);
        btnClearRemove.setBounds(210, 100, 160, 47);

        btnResetRemove.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnResetRemove.setText("Reset");
        btnResetRemove.setToolTipText("Reset Entire Thing.");
        btnResetRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetRemoveActionPerformed(evt);
            }
        });
        jPanel6.add(btnResetRemove);
        btnResetRemove.setBounds(30, 100, 160, 47);

        btnSelectRow.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnSelectRow.setText("Select Row");
        btnSelectRow.setToolTipText("Single selection of a row.");
        btnSelectRow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelectRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectRowActionPerformed(evt);
            }
        });
        jPanel6.add(btnSelectRow);
        btnSelectRow.setBounds(30, 170, 160, 47);

        btnDeleteRow.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnDeleteRow.setText("Delete Row");
        btnDeleteRow.setToolTipText("Delete a single selection of a row.");
        btnDeleteRow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRowActionPerformed(evt);
            }
        });
        jPanel6.add(btnDeleteRow);
        btnDeleteRow.setBounds(210, 170, 160, 47);

        btnViewAllDataRemove.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnViewAllDataRemove.setText("View All Hostel Room Data");
        btnViewAllDataRemove.setToolTipText("View All Hostel Room Data");
        btnViewAllDataRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAllDataRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllDataRemoveActionPerformed(evt);
            }
        });
        jPanel6.add(btnViewAllDataRemove);
        btnViewAllDataRemove.setBounds(30, 30, 340, 50);

        btnSelectedDelete.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnSelectedDelete.setText("Selected Delete (Careful !!!)");
        btnSelectedDelete.setToolTipText("This Will Immediately Delete A Row Of Room Info.");
        btnSelectedDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelectedDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectedDeleteActionPerformed(evt);
            }
        });
        btnSelectedDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSelectedDeleteKeyPressed(evt);
            }
        });
        jPanel6.add(btnSelectedDelete);
        btnSelectedDelete.setBounds(30, 240, 340, 47);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(40, 110, 400, 330);

        Create.addTab("Delete", jPanel4);

        jPanel5.add(Create);
        Create.setBounds(20, 90, 480, 510);
        Create.getAccessibleContext().setAccessibleName("CRUDPanels");

        lblCRUDtitle.setFont(new java.awt.Font("Kanit SemiBold", 0, 48)); // NOI18N
        lblCRUDtitle.setForeground(new java.awt.Color(255, 255, 255));
        lblCRUDtitle.setText("Hostel Room Info CRUD");
        lblCRUDtitle.setName("AdminHRI"); // NOI18N
        jPanel5.add(lblCRUDtitle);
        lblCRUDtitle.setBounds(30, 30, 560, 40);

        btnQuitCRUD.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnQuitCRUD.setText("Quit App");
        btnQuitCRUD.setToolTipText("Bye bye!");
        btnQuitCRUD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitCRUDActionPerformed(evt);
            }
        });
        jPanel5.add(btnQuitCRUD);
        btnQuitCRUD.setBounds(990, 30, 130, 40);

        btnBackCRUD.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnBackCRUD.setText("Back");
        btnBackCRUD.setToolTipText("Go Back.");
        btnBackCRUD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackCRUDActionPerformed(evt);
            }
        });
        jPanel5.add(btnBackCRUD);
        btnBackCRUD.setBounds(640, 30, 130, 40);

        btnNextCRUD.setFont(new java.awt.Font("Kanit Medium", 2, 18)); // NOI18N
        btnNextCRUD.setText(">> NEXT >>");
        btnNextCRUD.setToolTipText("Next to Admin Generate Report.");
        btnNextCRUD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNextCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextCRUDActionPerformed(evt);
            }
        });
        jPanel5.add(btnNextCRUD);
        btnNextCRUD.setBounds(810, 30, 130, 40);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 1200, 860);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearRemoveActionPerformed
        int selectedRow = roomsTable.getSelectedRow();
        if (selectedRow != -1) {
            roomsTable.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }//GEN-LAST:event_btnClearRemoveActionPerformed

    private void btnUpdateRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRoomsTableActionPerformed
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();

        // Retrieve the input values from the text fields
        String roomNo = txtRoomNoUpdate.getText().trim().toUpperCase();;
        String roomType = (String) cbRoomTypeUpdate.getSelectedItem();
        String roomAvailability = (String) cbRoomStatusUpdate.getSelectedItem();
        String roomCapacity = txtRoomCapacityUpdate.getText().trim().toUpperCase().replaceAll("[^\\d]", "");
        String roomPrice = txtRoomPriceUpdate.getText().trim().toUpperCase().replaceAll("[^\\d]", "");

        int roomIDlength = roomNo.length();

        if (roomIDlength < 2) {
            roomNo = "0".concat(roomNo);
        }

        if (!roomNo.contains("HR")) {
            roomNo = "HR".concat(roomNo);
        }

        if (!roomPrice.contains("RM")) {
            roomPrice = "RM".concat(roomPrice);
        }

        // price suffix
//        if (roomPrice.contains("0")) {
//            if (!roomPrice.endsWith(".00")) {
//                if (roomPrice.endsWith(".")) {
//                    roomPrice = roomPrice.concat("00");
//                } else {
//                    roomPrice = roomPrice.concat(".00");
//                }
//            }
//        }
        if (!roomPrice.endsWith(".00")) {
            roomPrice = roomPrice.concat(".00");
        }

        if (roomPrice.contains(".00")) {
            roomPrice = roomPrice.replace(".00", " ");
        }

        if (roomPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value for Room Price.");
            return;
        }

        if (roomCapacity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value for Room Capacity.");
            return;
        }

        if (cbRoomTypeUpdate.getSelectedItem().equals("<-- SELECT -->")) {
            JOptionPane.showMessageDialog(this, "Please select a value for Room Type.");
            return;
        }

        if (cbRoomStatusUpdate.getSelectedItem().equals("<-- SELECT -->")) {
            JOptionPane.showMessageDialog(this, "Please select a value for Room Status.");
            return;
        }

//        if (Double.parseDouble(roomPrice) < 350.00) {
//            JOptionPane.showMessageDialog(this, "Room Price cannot be less than RM350.00. Please re-enter.");
//            return;
//        }
        if (Integer.parseInt(roomCapacity) <= 0) {
            JOptionPane.showMessageDialog(this, "Room Capacity cannot be less than or equal to 0. Please re-enter.");
            return;
        }

//        try {
//            double price = Double.parseDouble(roomPrice);
//            if (price < 350.00) {
//                JOptionPane.showMessageDialog(this, "Room Price cannot be less than RM350.00. Please re-enter.");
//                return;
//            }
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(this, "Invalid Room Price. Please enter a valid numeric value.");
//            return;
//        }
        // Find the row with the matching roomNo and update its values
        boolean updated = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).toString().equals(roomNo)) {
                if (!cbRoomTypeUpdate.getSelectedItem().equals("<-- SELECT -->")) {
                    model.setValueAt(roomType, i, 1);
                }
                model.setValueAt(roomCapacity, i, 2);
                if (!cbRoomStatusUpdate.getSelectedItem().equals("<-- SELECT -->")) {
                    model.setValueAt(roomAvailability, i, 3);
                }
                model.setValueAt(roomPrice, i, 4);
                updated = true;
                break;
            }
        }

        // Check if roomCapacity and roomPrice have valid values
        if (updated && (roomCapacity.isEmpty() || roomPrice.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Missing information. Update failed.");
            return;
        }

        // Check if room availability and capacity have valid values
        if (updated && cbRoomTypeUpdate.getSelectedIndex() == 0 && cbRoomStatusUpdate.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select Room Capacity and Room Availability. Update failed.");
            return;
        }

        // Update the room information in the text file
        try {
            BufferedWriter bwUpdate = new BufferedWriter(new FileWriter("room.txt"));

            // Write the column headers
            bwUpdate.write("Room No., Room Type, Room Capacity, Room Status, Room Price\n");

            // Write each row of data to the file
            for (int i = 0; i < model.getRowCount(); i++) {
                String roomInfo = model.getValueAt(i, 0) + ", "
                        + model.getValueAt(i, 1) + ", "
                        + model.getValueAt(i, 2) + ", "
                        + model.getValueAt(i, 3) + ", "
                        + model.getValueAt(i, 4) + "\n";
                bwUpdate.write(roomInfo);
            }

            bwUpdate.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Show a message dialog to indicate whether the update was successful or not
        if (updated) {
            JOptionPane.showMessageDialog(this, "Room information updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Room not found. Update failed.");
        }
    }//GEN-LAST:event_btnUpdateRoomsTableActionPerformed

    private void btnCreateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRoomActionPerformed

        // If-else conditions to check both combo boxes together
        if (cbRoomStatus.getSelectedIndex() != 0 && cbRoomType.getSelectedIndex() != 0) {
            try {
                // Save the selected room type and create the room
                String selectedRoomType = cbRoomType.getSelectedItem().toString();
                saveSelectedRoomType(selectedRoomType);
                CreateRoom();
            } catch (IOException ex) {
                Logger.getLogger(AdminHRI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Show a warning message and do not create the room
            JOptionPane.showMessageDialog(null, "Please select a room type and a room status.", "Warning", JOptionPane.WARNING_MESSAGE);
            // Set focus on the appropriate combo box based on the selection
            if (cbRoomStatus.getSelectedIndex() == 0) {
                cbRoomStatus.requestFocus();
            } else {
                cbRoomType.requestFocus();
            }
        }
    }//GEN-LAST:event_btnCreateRoomActionPerformed

    void CreateRoom() throws IOException {
        String roomID = txtRoomNo.getText().trim().toUpperCase();
        String roomCapacity = txtRoomCapacity.getText().trim().replaceAll("[^\\d]", "");
        String roomPrice = txtRoomPrice.getText().trim().toUpperCase().replaceAll("[^\\d]", "");

        int roomIDlength = roomID.length();

        if (roomIDlength < 2) {
            roomID = "0".concat(roomID);
        }

        if (!roomID.contains("HR")) {
            roomID = "HR".concat(roomID);
        }

        if (!roomPrice.contains("RM")) {
            roomPrice = "RM".concat(roomPrice);
        }

        if (!roomPrice.endsWith(".00")) {
            roomPrice = roomPrice.concat(".00");
        }

//        if (roomPrice.contains(".00")) {
//            roomPrice = roomPrice.replace(".00", " ");
//        }
        if (roomPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value for Room Price.");
            return;
        }

        if (roomCapacity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value for Room Capacity.");
            return;
        }

        if (roomCapacity.isEmpty() || roomPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing information. Room creation failed.");
            return;
        }

        if (cbRoomType.getSelectedIndex() == 0 || cbRoomStatus.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select Room Capacity and Room Availability. Room creation failed.");
            return;
        }

        if (cbRoomTypeUpdate.getSelectedItem().equals("<-- SELECT -->")) {
            JOptionPane.showMessageDialog(this, "Please select a value for Room Type.");
            return;
        }

        if (cbRoomStatusUpdate.getSelectedItem().equals("<-- SELECT -->")) {
            JOptionPane.showMessageDialog(this, "Please select a value for Room Status.");
            return;
        }

        if (Integer.parseInt(roomCapacity) <= 0) {
            JOptionPane.showMessageDialog(this, "Room Capacity cannot be less than or equal to 0. Please re-enter.");
            return;
        }

        String roomType = cbRoomType.getSelectedItem().toString();
        String roomAvailability = cbRoomStatus.getSelectedItem().toString();

        handleFiles file = new handleFiles("room.txt");

        // Read the contents of the file
        List<String> lines = Files.readAllLines(Paths.get("room.txt"));

        // Check if the room number already exists
        for (String line : lines) {
            String[] parts = line.split(",");
            if (roomID.equals(parts[0])) {
                JOptionPane.showMessageDialog(this, "Room number already exists. Please choose a different room number.");
                return;
            }
        }
        // If the room number does not already exist, add the data to the file
        String[] data = {roomID, roomType, roomCapacity, roomAvailability, roomPrice};
//
//        if (roomID.equals(roomID)) {
//            JOptionPane.showMessageDialog(this, "Room number already exists. Please choose a different room number.");
//            return;
//        }

        if (file.writer(data)) {
            JOptionPane.showMessageDialog(this, "New booking data has been added successfully.", "Insertion Successfull", JOptionPane.INFORMATION_MESSAGE);
            try {
                importData();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminHRI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "An error has occured while inserting!", "Insertion Failed", JOptionPane.WARNING_MESSAGE);
        }

    }


    private void roomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsTableMouseClicked

    }//GEN-LAST:event_roomsTableMouseClicked

    private void cbRoomStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomStatusActionPerformed
//        this.setEnabled(false);


    }//GEN-LAST:event_cbRoomStatusActionPerformed

    public abstract class RoomType {

        protected String roomTypeName;

        public RoomType(String roomTypeName) {
            this.roomTypeName = roomTypeName;
        }

        public String getRoomTypeName() {
            return roomTypeName;
        }

        public abstract void displayInfo();
    }

    public class Dormitory extends RoomType {

        private int bedCount;

        public Dormitory(String roomTypeName, int bedCount) {
            super(roomTypeName);
            this.bedCount = bedCount;
        }

        @Override
        public void displayInfo() {
            System.out.println("Room Type: " + roomTypeName);
            System.out.println("Bed Count: " + bedCount);
        }
    }

    public class Shared extends RoomType {

        private int bedCount;

        public Shared(String roomTypeName, int bedCount) {
            super(roomTypeName);
            this.bedCount = bedCount;
        }

        @Override
        public void displayInfo() {
            System.out.println("Room Type: " + roomTypeName);
            System.out.println("Bed Count: " + bedCount);
        }
    }

    public class Private extends RoomType {

        private int bedCount;

        public Private(String roomTypeName, int bedCount) {
            super(roomTypeName);
            this.bedCount = bedCount;
        }

        @Override
        public void displayInfo() {
            System.out.println("Room Type: " + roomTypeName);
            System.out.println("Bed Count: " + bedCount);
        }
    }

    public void populateComboBox() {
        roomTypes = new ArrayList<>();
        roomTypes.add(new Dormitory("Dormitory", 8));
        roomTypes.add(new Shared("Shared", 6));
        roomTypes.add(new Private("Private", 2));

        cbRoomType.removeAllItems();
        cbRoomType.addItem("Select Room Type"); // Add a default option

        for (RoomType roomType : roomTypes) {
            cbRoomType.addItem(roomType.getRoomTypeName());
        }
    }

    private void cbRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomTypeActionPerformed
        Object selectedRoomTypeObj = cbRoomType.getSelectedItem();
        if (selectedRoomTypeObj != null) {
            String selectedRoomType = selectedRoomTypeObj.toString();

            if (!selectedRoomType.equals("Select Room Type")) {
                for (RoomType roomType : roomTypes) {
                    if (roomType.getRoomTypeName().equals(selectedRoomType)) {
                        roomType.displayInfo();
                        break;
                    }
                }
            }
        }

    }//GEN-LAST:event_cbRoomTypeActionPerformed

    private String selectedRoomType;

    private String selectedRoomTypeUpdate;

    private void saveSelectedRoomType(String roomType) {

        selectedRoomType = roomType; // save the selected room type to a variable
    }

    private void saveSelectedRoomTypeUpdate(String roomType) {

        selectedRoomTypeUpdate = roomType; // save the selected room type to a variable
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // The Room Table
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.setRowCount(0);

        // CRUD side
        txtRoomNo.setText("");
        cbRoomType.setSelectedIndex(0);
        cbRoomStatus.setSelectedIndex(0);
        txtRoomCapacity.setText("");
        txtRoomPrice.setText("");

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // CRUD side
        txtRoomNo.setText("");
        cbRoomType.setSelectedIndex(0);
        cbRoomStatus.setSelectedIndex(0);
        txtRoomCapacity.setText("");
        txtRoomPrice.setText("");

        // check if the room type combo box has the default value
        if (cbRoomType.getSelectedItem().toString().equals("<-- SELECT -->")) {
            // if it does, don't call the saveSelectedRoomType method
            return;
        }

        // get the selected room type and save it
        String selectedRoomType = cbRoomType.getSelectedItem().toString();
        saveSelectedRoomType(selectedRoomType);
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void btnSearchDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDisplayActionPerformed
        String roomNo = txtRoomNoDisplay.getText().trim().toUpperCase();
        if (roomNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input hostel room number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            boolean roomFound = display(roomNo);
            if (roomFound) {
                JOptionPane.showMessageDialog(this, "Room found.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Hostel room number not found. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AdminHRI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchDisplayActionPerformed

    private void btnResetDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDisplayActionPerformed
        // The Room Table
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.setRowCount(0);

        // CRUD side
        txtRoomNo.setText("");
        cbRoomType.setSelectedIndex(0);
        cbRoomStatus.setSelectedIndex(0);
        txtRoomCapacity.setText("");
        txtRoomPrice.setText("");
    }//GEN-LAST:event_btnResetDisplayActionPerformed

    private void btnClearDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearDisplayActionPerformed
        // CRUD side
        txtRoomNoDisplay.setText("");

        // check if the room type combo box has the default value
        if (cbRoomType.getSelectedItem().toString().equals("<-- SELECT -->")) {
            // if it does, don't call the saveSelectedRoomType method
            return;
        }

        // get the selected room type and save it
        String selectedRoomType = cbRoomType.getSelectedItem().toString();
        saveSelectedRoomType(selectedRoomType);
    }//GEN-LAST:event_btnClearDisplayActionPerformed

    private void txtRoomNoDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomNoDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomNoDisplayActionPerformed

    private void btnSortingTableDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortingTableDataActionPerformed
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        roomsTable.setRowSorter(sorter);
        sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
    }//GEN-LAST:event_btnSortingTableDataActionPerformed

    private void btnViewAllRoomInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllRoomInfoActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
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
            Logger.getLogger(AdminHRI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewAllRoomInfoActionPerformed

    private void cbRoomTypeUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomTypeUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRoomTypeUpdateActionPerformed

    private void cbRoomStatusUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomStatusUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRoomStatusUpdateActionPerformed

    private void btnResetUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetUpdateActionPerformed
        // The Room Table
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.setRowCount(0);

        // CRUD side
        txtRoomNoUpdate.setText("");
        cbRoomTypeUpdate.setSelectedIndex(0);
        cbRoomStatusUpdate.setSelectedIndex(0);
        txtRoomCapacityUpdate.setText("");
        txtRoomPriceUpdate.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetUpdateActionPerformed

    private void btnClearUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearUpdateActionPerformed
        // CRUD side
        txtRoomNoUpdate.setText("");
        cbRoomTypeUpdate.setSelectedIndex(0);
        cbRoomStatusUpdate.setSelectedIndex(0);
        txtRoomCapacityUpdate.setText("");
        txtRoomPriceUpdate.setText("");

        // check if the room type combo box has the default value
        if (cbRoomTypeUpdate.getSelectedItem().toString().equals("<-- SELECT -->")) {
            // if it does, don't call the saveSelectedRoomType method
            return;
        }

        // get the selected room type and save it
        String selectedRoomTypeUpdate = cbRoomTypeUpdate.getSelectedItem().toString();
        saveSelectedRoomType(selectedRoomTypeUpdate);
    }//GEN-LAST:event_btnClearUpdateActionPerformed

    private void CreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateMouseClicked
        // This Is The Panel Includes CRUD Panels.

    }//GEN-LAST:event_CreateMouseClicked


    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // Enable the JTable
        roomsTable.setEnabled(true);

        // Set the selection mode of the JTable to single selection
        roomsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Clear any previous selection
//        roomsTable.clearSelection();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
//        roomsTable.setEnabled(false);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
//        roomsTable.setEnabled(false);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
//        roomsTable.setEnabled(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnSelectedDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedDeleteActionPerformed
        DefaultTableModel model2 = (DefaultTableModel) roomsTable.getModel();

        // Set Table
        roomsTable.setEnabled(true);

        // Set the selection mode of the JTable to single selection
        roomsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        int selectedRow = roomsTable.getSelectedRow();

        if (selectedRow == -1) { // No row selected
            JOptionPane.showMessageDialog(null, "Please select a room to delete.");
            btnSelectedDelete.requestFocus();
            return;
        }

        // Get the room number of the selected row
        String roomNo = (String) model2.getValueAt(selectedRow, 0);

        // Remove the selected row from the table model
        model2.removeRow(selectedRow);

        // Update the room information in the text file
        try {
            // Create temporary file
            File inputFile = new File("room.txt");
            File tempFile = new File("temp.txt");

            // Read the contents of the file and remove the line with the corresponding room number
            try ( BufferedReader reader = new BufferedReader(new FileReader(inputFile));  PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (!roomNo.equals(parts[0])) {
                        writer.println(line);
                    }
                }
            }

            // Replace the original file with the temporary file
            Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSelectedDeleteActionPerformed

    private void btnDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRowActionPerformed
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();

        // Get the index of the selected row
        int selectedRow = roomsTable.getSelectedRow();

        // Check if a row is selected and it is not the first row
        if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
            // Show confirmation dialog
            int confirmDialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmDialogResult == JOptionPane.YES_OPTION) {
                // Remove the selected row from the JTable
                model.removeRow(selectedRow);

                // Save the updated data to the text file
                try {
                    try ( PrintWriter pw = new PrintWriter(new FileWriter("room.txt"))) {
                        // Write the column headers
                        pw.write("Room No., Room Type, Room Capacity, Room Status, Room Price\n");

                        for (int i = 0; i < model.getRowCount(); i++) {
                            for (int j = 0; j < model.getColumnCount(); j++) {
                                pw.print(model.getValueAt(i, j));
                                if (j < model.getColumnCount() - 1) {
                                    pw.print(", ");
                                }
                            }
                            pw.println();
                        }
                    }
                    // Show success dialog
                    JOptionPane.showMessageDialog(this, "Row removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a valid row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteRowActionPerformed

    private void btnSelectRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectRowActionPerformed
        // Enable the JTable
        roomsTable.setEnabled(true);

        // Set the selection mode of the JTable to single selection
        roomsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Clear any previous selection
        roomsTable.clearSelection();
    }//GEN-LAST:event_btnSelectRowActionPerformed

    private void btnResetRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetRemoveActionPerformed
        // The Room Table
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_btnResetRemoveActionPerformed

    private void btnViewAllDataRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllDataRemoveActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
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
            Logger.getLogger(AdminHRI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewAllDataRemoveActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked

        roomsTable.setEnabled(true);
        roomsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void btnQuitCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitCRUDActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnQuitCRUDActionPerformed

    private void btnBackCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackCRUDActionPerformed
        AdminMainMenu amm = new AdminMainMenu(userSession); // Pass the UserSession instance
        amm.setLocationRelativeTo(null);
        amm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackCRUDActionPerformed

    private void btnNextCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextCRUDActionPerformed
        UserSession userSession = new UserSession("admin"); // Create UserSession instance with username
        CheckStudentRecord csr = new CheckStudentRecord(userSession);
        csr.setLocationRelativeTo(null);
        csr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNextCRUDActionPerformed

    private void txtRoomNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomNoActionPerformed

    private void txtRoomCapacityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRoomCapacityMouseClicked
        txtRoomCapacity.setText(" ");
    }//GEN-LAST:event_txtRoomCapacityMouseClicked

    private void txtRoomPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRoomPriceMouseClicked
        txtRoomPrice.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomPriceMouseClicked

    private void txtRoomNoDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRoomNoDisplayMouseClicked
        txtRoomNoDisplay.setText(" ");
    }//GEN-LAST:event_txtRoomNoDisplayMouseClicked

    private void txtRoomNoUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRoomNoUpdateMouseClicked
        txtRoomNoUpdate.setText(" ");

    }//GEN-LAST:event_txtRoomNoUpdateMouseClicked

    private void txtRoomCapacityUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRoomCapacityUpdateMouseClicked
        txtRoomCapacityUpdate.setText(" ");
    }//GEN-LAST:event_txtRoomCapacityUpdateMouseClicked

    private void txtRoomPriceUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRoomPriceUpdateMouseClicked
        txtRoomPriceUpdate.setText(" ");
    }//GEN-LAST:event_txtRoomPriceUpdateMouseClicked

    private void btnCreateRoomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCreateRoomKeyPressed
        // If-else conditions to check both combo boxes together
        if (cbRoomStatus.getSelectedIndex() != 0 && cbRoomType.getSelectedIndex() != 0) {
            try {
                // Save the selected room type and create the room
                String selectedRoomType = cbRoomType.getSelectedItem().toString();
                saveSelectedRoomType(selectedRoomType);
                CreateRoom();
            } catch (IOException ex) {
                Logger.getLogger(AdminHRI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Show a warning message and do not create the room
            JOptionPane.showMessageDialog(null, "Please select a room type and a room status.", "Warning", JOptionPane.WARNING_MESSAGE);
            // Set focus on the appropriate combo box based on the selection
            if (cbRoomStatus.getSelectedIndex() == 0) {
                cbRoomStatus.requestFocus();
            } else {
                cbRoomType.requestFocus();
            }
        }
    }//GEN-LAST:event_btnCreateRoomKeyPressed

    private void txtRoomPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomPriceActionPerformed

    private void txtRoomNoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomNoUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomNoUpdateActionPerformed

    private void txtRoomCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomCapacityActionPerformed

    private void btnSelectedDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSelectedDeleteKeyPressed


    }//GEN-LAST:event_btnSelectedDeleteKeyPressed

    private void txtRoomPriceUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomPriceUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomPriceUpdateActionPerformed

    public boolean display(String roomNo) throws FileNotFoundException {
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.setRowCount(0);

        handleFiles file = new handleFiles("room.txt");
        Object[] fileData = file.reader();

        boolean roomFound = false;

        for (var i = 0; i < fileData.length; i++) {
            String line = fileData[i].toString().trim();
            String[] dataRow = line.split(", ");
            if (i == 0) {
                model.setColumnIdentifiers(dataRow);
            } else if (dataRow[0].equals(roomNo)) {
                model.addRow(dataRow);
                roomFound = true;
            }
        }

        return roomFound;
    }

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
            java.util.logging.Logger.getLogger(AdminHRI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHRI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHRI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHRI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserSession userSession = new UserSession("admin"); // Create UserSession instance with username
                try {
                    new AdminHRI(userSession).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AdminHRI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Create;
    private javax.swing.JButton btnBackCRUD;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnClearDisplay;
    private javax.swing.JButton btnClearRemove;
    private javax.swing.JButton btnClearUpdate;
    private javax.swing.JButton btnCreateRoom;
    private javax.swing.JButton btnDeleteRow;
    private javax.swing.JButton btnNextCRUD;
    private javax.swing.JButton btnQuitCRUD;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetDisplay;
    private javax.swing.JButton btnResetRemove;
    private javax.swing.JButton btnResetUpdate;
    private javax.swing.JButton btnSearchDisplay;
    private javax.swing.JButton btnSelectRow;
    private javax.swing.JButton btnSelectedDelete;
    private javax.swing.JButton btnSortingTableData;
    private javax.swing.JButton btnUpdateRoomsTable;
    private javax.swing.JButton btnViewAllDataRemove;
    private javax.swing.JButton btnViewAllRoomInfo;
    private javax.swing.JComboBox<String> cbRoomStatus;
    private javax.swing.JComboBox<String> cbRoomStatusUpdate;
    private javax.swing.JComboBox<String> cbRoomType;
    private javax.swing.JComboBox<String> cbRoomTypeUpdate;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCRUDtitle;
    private javax.swing.JLabel lblCRUDtitle2;
    private javax.swing.JLabel lblCRUDtitle3;
    private javax.swing.JLabel lblCRUDtitle4;
    private javax.swing.JLabel lblCRUDtitle5;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable roomsTable;
    private javax.swing.JTextField txtRoomCapacity;
    private javax.swing.JTextField txtRoomCapacityUpdate;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtRoomNoDisplay;
    private javax.swing.JTextField txtRoomNoUpdate;
    private javax.swing.JTextField txtRoomPrice;
    private javax.swing.JTextField txtRoomPriceUpdate;
    // End of variables declaration//GEN-END:variables
}

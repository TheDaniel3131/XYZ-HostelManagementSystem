package hostelmanagementsystem.Admin;

import java.io.FileNotFoundException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataImporter {
    private handleFiles file;

    public DataImporter(String fileName) {
        file = new handleFiles(fileName);
    }

    public String generateRoomNumber() throws FileNotFoundException {
        int roomID = file.lineNumber();
        return "HR" + roomID;
    }

    public void importData(JTable table) throws FileNotFoundException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] fileData = file.reader();

        for (var i = 0; i < fileData.length; i++) {
            String line = fileData[i].toString().trim();
            String[] dataRow = line.split(", ");
            if (i == 0) {
                model.setColumnIdentifiers(dataRow);
            } else {
                model.addRow(dataRow);
            }
        }
    }
}

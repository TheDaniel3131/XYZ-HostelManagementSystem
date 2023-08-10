package hostelmanagementsystem.Admin;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomReportGenerator {
    public void generateReport(String tableData, String reportName) {
        System.out.println("Room Report Is Generating...");
        try (FileWriter writer = new FileWriter(reportName + ".txt")) {
            writer.write("**********************" + System.lineSeparator());
            writer.write("**********************" + System.lineSeparator());
            writer.write("   Room Report   " + System.lineSeparator());
            writer.write("**********************" + System.lineSeparator());
            writer.write("**********************" + System.lineSeparator());
            writer.write(System.lineSeparator());

            writer.write(tableData); // Write the table data

            writer.write(System.lineSeparator());
            writer.write("***************************************" + System.lineSeparator());
            writer.write("   Generated On: " + getCurrentDateTime() + System.lineSeparator());
            writer.write("   Signature: admin" + System.lineSeparator());
            writer.write("***************************************" + System.lineSeparator());
            System.out.println("Report generated successfully.");
        } catch (IOException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }

    private static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}

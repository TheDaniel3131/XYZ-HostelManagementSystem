package hostelmanagementsystem.Admin;

public class ExtendedRRG extends RoomReportGenerator {
    public void generateExtendedReport(String tableData, String reportName) {
        System.out.println("Extended Room Report Is Generating...");
        super.generateReport(tableData, reportName); // Invoke the generateReport method of the parent class
        System.out.println("Extended report generated successfully.");
    }
}

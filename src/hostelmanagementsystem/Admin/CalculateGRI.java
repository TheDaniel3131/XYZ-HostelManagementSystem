package hostelmanagementsystem.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;


public class CalculateGRI extends OccupancyCalculator {

    @Override
    protected void calculateOccupancyRate() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("room.txt"));
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[3].trim().equalsIgnoreCase("available")) {
                totalRooms++;
            } else {
                totalRooms++;
                occupiedRooms++;
            }
        }
        occupancyRate = (double) occupiedRooms / totalRooms * 100;
        DecimalFormat df = new DecimalFormat("#.##");
        formattedOccupancyRate = df.format(occupancyRate);
    }

    @Override
    protected void writeResultsToFile() throws IOException {
        try (PrintWriter writer = new PrintWriter("cgri.txt", "UTF-8")) {
            writer.println("Total Hostel Rooms: " + totalRooms);
            writer.println("Total Occupied Rooms: " + occupiedRooms);
            writer.println("Occupancy Rate: " + formattedOccupancyRate + "%");
        }
    }

    public static void main(String[] args) throws IOException {
        CalculateGRI gri = new CalculateGRI();
        gri.run();
    }
}

package hostelmanagementsystem.Admin;

import java.io.IOException;

/**
 *
 * @author Daniel
 */
public abstract class OccupancyCalculator {

    protected int totalRooms = 0;
    protected int occupiedRooms = 0;
    protected double occupancyRate = 0.0;
    protected String formattedOccupancyRate = "";

    public void run() throws IOException {
        calculateOccupancyRate();
        writeResultsToFile();
    }

    protected abstract void calculateOccupancyRate() throws IOException;

    protected abstract void writeResultsToFile() throws IOException;

}
package parkinglot;
import vehicle.Vehicle;
import java.time.LocalDateTime;
import parkinglot.parkingspot.ParkingSpot;

public class Ticket 
{
    private ParkingSpot parkingSpot;
    private Vehicle vehicle; 
    private LocalDateTime startTime;

    // Ctor for initialisation 
    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle)
    {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.startTime = LocalDateTime.now(); // current time
    }

    // getter for startTime
    public LocalDateTime getStartTime()
    {
        return this.startTime;
    }
}

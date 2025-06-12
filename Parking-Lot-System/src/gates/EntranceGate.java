package gates;
import java.util.Scanner;
import vehicle.Vehicle;
import vehicle.VehicleFactory;
import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.parkingspot.ParkingSpot;

public class EntranceGate 
{
    private ParkingLot parkingLot;
    
    // Ctor for initialisation
    public EntranceGate(ParkingLot parkingLot)
    {
        this.parkingLot = parkingLot;
    }

    // Process after the entrance of vehicle
    public void processEntrance()
    {
        Scanner scanner = new Scanner(System.in);

        // Take input
        System.out.println("Enter the vehicle licensePlate: ");
        String licensePlate = scanner.nextLine();
        System.out.println("Enter the vehicle type: ");
        String vehicleType = scanner.nextLine().toUpperCase(); // to ignore case

        // Create vehicle using Vehicle Factory
        Vehicle vehicle = VehicleFactory.createVehicle(vehicleType, licensePlate);
        if(vehicle == null)
        {
            // Invalid vehicle type input
            System.out.println("Invalid Vehicle type! Only Bike, Car, Van and Truck are allowed.");
            return;
        }

        // Find parkingSpot 
        ParkingSpot spot = parkingLot.parkVehicle(vehicle);
        if(spot != null)
        {   
            // Spot found

            // Create a Ticket
            Ticket ticket = new Ticket(spot, vehicle);

            // Print Details
            System.out.println("Vehicle Parked Successfully at spot: " + spot.getSpotNumber());
            System.out.println("Ticket Generated");
            System.out.println("Vehicle: " + vehicle.getLicensePlate());
            System.out.println("Spot: " + spot.getSpotNumber());
            System.out.println("Entry Time: " + ticket.getStartTime());
        }
        // spot not found handled in parkinglot class
    }
    
}

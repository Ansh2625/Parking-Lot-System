package parkinglot;
import java.util.List;
import vehicle.Vehicle;
import parkinglot.parkingspot.ParkingSpot;

public class ParkingLot // Singleton
{
    // private static instance
    private static ParkingLot parkingLotInstance = null;
    
    // ParkingLot may have multiple floors
    private List<ParkingFloor> floors; 

    // private Ctor for initialisation
    private ParkingLot(List<ParkingFloor> floors)
    {
        this.floors = floors;
    }

    // Create only one instance and handle Multithreading
    public static ParkingLot getInstance(List<ParkingFloor> floors)
    {
        if(parkingLotInstance == null)
        {
            synchronized (ParkingLot.class)
            {
                if(parkingLotInstance == null)
                {
                    parkingLotInstance = new ParkingLot(floors);
                }
            }
        }
        return parkingLotInstance;
    }

    // Find the reqired spot as per vehicle type
    public ParkingSpot findAvailableSpot(String vehicleType)
    {
        // On each floor
        for(ParkingFloor floor : floors)
        {
            // find the required spot 
            ParkingSpot spot = floor.findAvailableSpot(vehicleType);

            // spot found
            if(spot != null)
                return spot;
        }

        // spot not found
        return null;
    }

    // Park vehicle
    public ParkingSpot parkVehicle(Vehicle vehicle)
    {
        // find spot according to vehicle type
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());

        // spot found
        if(spot != null)
        {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle successfully parked at spot: " + spot.getSpotNumber());
            return spot;
        }

        // spot not found
        System.out.println("No parking spot available for " + vehicle.getVehicleType());
        return null;
    }

    // Vacate the spot
    public void vacateSpot(ParkingSpot spot, Vehicle vehicle)
    {
        // if spot not empty and is occupied by vehicle to be removed
        if(spot!=null && spot.isOccupied() && spot.getVehicle().equals(vehicle))
        {
            spot.vacate();
            System.out.println(vehicle.getVehicleType() + " vacated the spot: " + spot.getSpotNumber());
        }
        else
        {
            System.out.println("Invalid Operation! Either the spot is already vacant or vehicle do not match.");
        }
    }

    // get the spot object by its number [for vacate]
    public ParkingSpot getSpotByNumber(int spotNumber)
    {
        // At each floor
        for(ParkingFloor floor : floors)
        {
            // check all spots
            for(ParkingSpot spot : floor.getParkingSpots())
            {
                // found
                if(spot.getSpotNumber() == spotNumber)
                    return spot;
            }
        }
        // not found
        return null;
    }

    // Getter for floors
    public List<ParkingFloor> getFloors()
    {
        return floors;
    }
}

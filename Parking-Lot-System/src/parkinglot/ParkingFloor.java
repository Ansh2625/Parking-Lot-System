package parkinglot;
import java.util.List;
import java.util.ArrayList;
import parkinglot.parkingspot.*;

public class ParkingFloor 
{
    // List of spots on a particular floor
    private List<ParkingSpot> spots;    
    private int floorNumber;

    // Ctor for initialisation
    public ParkingFloor(int floorNumber, int noOfBikeSpots, int noOfCarSpots, int noOfVanSpots, int noOfTruckSpots)
    {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();

        // Add the spots on a floor
        int currentSpot = 1;
        for(int i=0; i<noOfBikeSpots; i++)
        {
            this.spots.add(new BikeParkingSpot(currentSpot++));
        }
        for(int i=0; i<noOfCarSpots; i++)
        {
            this.spots.add(new CarParkingSpot(currentSpot++));
        }
        for(int i=0; i<noOfVanSpots; i++)
        {
            this.spots.add(new VanParkingSpot(currentSpot++));
        }
        for(int i=0; i<noOfTruckSpots; i++)
        {
            this.spots.add(new TruckParkingSpot(currentSpot++));
        }
    }

    // find the required spot
    public ParkingSpot findAvailableSpot(String vehicleType)
    {
        // on a floor check for each spot, if empty and is of required type
        for(ParkingSpot spot : spots)
        {
            if(!spot.isOccupied() && spot.getSpotType().equals(vehicleType))
                return spot;
        }
        // if not found
        return null;
    }

    // getter
    public List<ParkingSpot> getParkingSpots()
    {
        return this.spots;
    }
}

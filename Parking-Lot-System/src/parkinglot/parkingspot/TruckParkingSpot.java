package parkinglot.parkingspot;
import vehicle.Vehicle;

public class TruckParkingSpot extends ParkingSpot
{
    public TruckParkingSpot(int spotNumber)
    {
        super(spotNumber, "TRUCK");
    }   

    public boolean canParkVehicle(Vehicle vehicle)
    {
        return "TRUCK".equals(vehicle.getVehicleType());
    }
}

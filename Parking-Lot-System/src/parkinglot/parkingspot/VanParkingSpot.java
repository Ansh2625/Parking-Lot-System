package parkinglot.parkingspot;
import vehicle.Vehicle;

public class VanParkingSpot extends ParkingSpot
{
    public VanParkingSpot(int spotNumber)
    {
        super(spotNumber, "VAN");
    }    

    public boolean canParkVehicle(Vehicle vehicle)
    {
        return "VAN".equals(vehicle.getVehicleType());
    }
}

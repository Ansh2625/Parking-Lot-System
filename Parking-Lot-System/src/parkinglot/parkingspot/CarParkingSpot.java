package parkinglot.parkingspot;
import vehicle.Vehicle;

public class CarParkingSpot extends ParkingSpot
{
    public CarParkingSpot(int spotNumber)
    {
        super(spotNumber, "CAR");
    }    

    public boolean canParkVehicle(Vehicle vehicle)
    {
        return "CAR".equals(vehicle.getVehicleType());
    }
}

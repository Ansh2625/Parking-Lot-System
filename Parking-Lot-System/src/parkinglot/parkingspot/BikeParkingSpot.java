package parkinglot.parkingspot;

import vehicle.Vehicle;

public class BikeParkingSpot extends ParkingSpot
{
    public BikeParkingSpot(int spotNumber)
    {
        super(spotNumber, "BIKE");
    }    

    public boolean canParkVehicle(Vehicle vehicle)
    {
        return "BIKE".equals(vehicle.getVehicleType());
    }
}

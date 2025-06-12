package vehicle;

public class VehicleFactory 
{
    public static Vehicle createVehicle(String vehicleType, String licensePlate)
    {
        if(vehicleType.equals("BIKE"))
        {
            return new BikeVehicle(licensePlate);
        }
        else if(vehicleType.equals("CAR"))
        {
            return new CarVehicle(licensePlate);
        }
        else if(vehicleType.equals("VAN"))
        {
            return new VanVehicle(licensePlate);
        }
        else if(vehicleType.equals("TRUCK"))
        {
            return new TruckVehicle(licensePlate);
        }
        else
            return null;
    }    
}

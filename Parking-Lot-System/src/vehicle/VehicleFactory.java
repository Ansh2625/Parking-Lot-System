package vehicle;

public class VehicleFactory 
{
    public static Vehicle createVehicle(String vehicleType, String licensePlate)
    {
        if(vehicleType.equals("Bike"))
        {
            return new BikeVehicle(licensePlate);
        }
        else if(vehicleType.equals("Car"))
        {
            return new CarVehicle(licensePlate);
        }
        else if(vehicleType.equals("Van"))
        {
            return new VanVehicle(licensePlate);
        }
        else if(vehicleType.equals("Truck"))
        {
            return new TruckVehicle(licensePlate);
        }
        else
            return null;
    }    
}

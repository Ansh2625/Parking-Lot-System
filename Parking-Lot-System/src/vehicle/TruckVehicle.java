package vehicle;

public class TruckVehicle extends Vehicle
{
    private final double Rate = 20.0;

    public TruckVehicle(String licensePlate)
    {
        super(licensePlate, "Truck");
    }

    public double getRate()
    {
        return this.Rate;
    }
}

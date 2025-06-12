package vehicle;

public class BikeVehicle extends Vehicle
{
    private final double Rate = 5.0;

    public BikeVehicle(String licensePlate)
    {
        super(licensePlate, "BIKE");
    }

    public double getRate()
    {
        return this.Rate;
    }
}
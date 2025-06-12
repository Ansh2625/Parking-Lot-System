package vehicle;

public class VanVehicle extends Vehicle
{
    private final double Rate = 15.0;

    public VanVehicle(String licensePlate)
    {
        super(licensePlate, "VAN");
    }

    public double getRate()
    {
        return this.Rate;
    }
}

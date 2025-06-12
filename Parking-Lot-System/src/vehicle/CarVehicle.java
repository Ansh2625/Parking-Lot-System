package vehicle;

public class CarVehicle extends Vehicle
{
    private final double Rate = 10.0;

    public CarVehicle(String licensePlate)
    {
        super(licensePlate,"CAR");
    }

    public double getRate()
    {
        return this.Rate;
    }
}

package vehicle;

public abstract class Vehicle 
{
    private String licensePlate;
    private String vehicleType;

    public Vehicle(String licensePlate, String vehicleType)
    {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate()
    {
        return this.licensePlate;
    }

    public String getVehicleType()
    {
        return this.vehicleType;
    }

    public double calculateFee(int hoursStayed)
    {
        return hoursStayed * getRate();
    }

    protected abstract double getRate();
}

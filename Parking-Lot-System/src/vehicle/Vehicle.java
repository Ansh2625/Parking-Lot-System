package vehicle;

public abstract class Vehicle 
{
    private String licensePlate;
    private String vehicleType;

    // Ctor for initialisation
    public Vehicle(String licensePlate, String vehicleType)
    {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    // Getters
    public String getLicensePlate()
    {
        return this.licensePlate;
    }
    public String getVehicleType()
    {
        return this.vehicleType;
    }

    // Fee Calculation
    public double calculateFee(int hoursStayed)
    {
        return hoursStayed * getRate();
    }

    // abstract function to get Rate accordingly
    protected abstract double getRate();
}

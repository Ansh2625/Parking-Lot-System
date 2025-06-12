package parkinglot.parkingspot;
import vehicle.Vehicle;

public abstract class ParkingSpot 
{
    private int spotNumber;
    private boolean occupied;
    private Vehicle vehicle;
    private String spotType;

    // Ctor for initialisation
    public ParkingSpot(int spotNumber, String spotType)
    {
        this.spotNumber = spotNumber;
        this.occupied = false; // intially empty
        this.spotType = spotType;
    }

    // abstract function
    public abstract boolean canParkVehicle(Vehicle vehicle);

    // getters
    public boolean isOccupied()
    {
        return this.occupied;
    }
    public int getSpotNumber()
    {
        return this.spotNumber;
    }
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }
    public String getSpotType()
    {
        return this.spotType;
    }

    // park the vehicle
    public void parkVehicle(Vehicle vehicle)
    {
        // if occupied is true then vehicle already parked at spot
        if(this.occupied)
        {
            throw new IllegalStateException("Spot is already occupied.");
        }
        // check can park particular vehicle or not at that spot
        if(!canParkVehicle(vehicle))
        {
            throw new IllegalArgumentException("This spot is not suitable for a " + vehicle.getVehicleType());
        }
        // park vehicle
        this.vehicle = vehicle;
        this.occupied = true;
    }

    // Vacate the spot
    public void vacate()
    {
        // check if the spot is already empty
        if(!this.occupied)
        {
            throw new IllegalStateException("Spot is already vacant.");
        }
        // vacate
        this.vehicle = null;
        this.occupied = false;
    }

}

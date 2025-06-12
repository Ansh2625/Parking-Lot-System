package gates;
import parkinglot.ParkingLot;
import parkinglot.parkingspot.ParkingSpot;
import payment.PaymentService;
import vehicle.Vehicle;

public class ExitGate 
{
    private ParkingLot parkingLot;

    // payment at exit
    private PaymentService paymentService;

    // Ctor for initialisation
    public ExitGate(ParkingLot parkingLot, PaymentService paymentService)
    {
        this.parkingLot = parkingLot;
        this.paymentService = paymentService;
    }

    // Process the exit of vehicle
    public void processExit(int spotNumber, int hoursStayed)
    {
        // get the spot 
        ParkingSpot spot = parkingLot.getSpotByNumber(spotNumber);

        // check valid spot
        if(spot==null || !spot.isOccupied())
        {
            System.out.println("Invalid or Vacant Spot.");
            return;
        }

        // valid spot
        // get vehicle on the spot
        Vehicle vehicle = spot.getVehicle();
        if(vehicle == null)
        {
            // no vehicle at spot
            System.out.println("No vehicle found on the spot.");
            return;
        }

        // vehicle found 

        // calculate the fee
        double fee = vehicle.calculateFee(hoursStayed);
        // process the payment
        paymentService.processPayment(fee);

        // Vacate the spot 
        parkingLot.vacateSpot(spot, vehicle);
        System.out.println("Spot vacant Successfully");
    }
}

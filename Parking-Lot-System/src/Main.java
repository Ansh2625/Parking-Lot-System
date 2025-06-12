import java.util.Scanner;

import gates.EntranceGate;
import gates.ExitGate;

import java.util.List;
import java.util.ArrayList;
import parkinglot.ParkingFloor;
import parkinglot.ParkingLot;
import payment.PaymentService;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        // Create number of floor and parking spots for each vehicletype
        // For Simplicity added one floor and two spots for each vehicle type
        ParkingFloor floor = new ParkingFloor(1, 2, 2, 2, 2);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor);

        // Initailise Parking Lot with the floors
        // Single instance, since Singleton pattern used
        ParkingLot parkingLot = ParkingLot.getInstance(floors);

        // Initialise the Payment Service
        // Single instance, since Singleton pattern used
        PaymentService paymentService = PaymentService.getInstance(scanner);

        // Initialise the Gates
        EntranceGate entranceGate = new EntranceGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot, paymentService);


        // Start of Parking Lot System
        System.out.println("\n============================================");
        System.out.println("       Welcome to Parking Lot System       ");
        System.out.println("============================================");

        // Continuous sessions until user exits
        boolean exit = false;
        while(!exit)
        {
            showMenu();

            // Take user choice
            int choice = getUserChoice(scanner);

            switch(choice)
            {
                case 1:
                    parkVehicle(entranceGate);
                    break;
                case 2:
                    vacateSpot(exitGate,scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for using the Parking Lot System.");
                    break;
                default:
                    System.out.println("Invalid choice! please choose again.");
                    break;
            }
        }

    }

    private static void showMenu()
    {
        System.out.println("\n**************************************");
        System.out.println("Please choose an option from below");
        System.out.println("1. Park a vehicle");
        System.out.println("2. Vacate a Spot");
        System.out.println("3. Exit the System");
        System.out.println("**************************************");
    }

    private static int getUserChoice(Scanner scanner)
    {
        return scanner.nextInt();
    }

    private static void parkVehicle(EntranceGate entranceGate)
    {
        entranceGate.processEntrance();
    }

    private static void vacateSpot(ExitGate exitGate, Scanner scanner)
    {
        System.out.println("Enter the spot number to vacate: ");
        int spotNumber = scanner.nextInt();

        // Number of hours stayed can be calculated from the ticket, can use a map to store the ticket with spot and then get the time vehicle stayed on it
        // for simplicity taking user input
        System.out.println("Enter number of hours the vehicle stayed: ");
        int hoursStayed = scanner.nextInt();

        exitGate.processExit(spotNumber, hoursStayed);
    }
}

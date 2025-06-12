package payment;
import java.util.Scanner;

public class PaymentService // Singleton
{
    // Private static instance
    private static PaymentService paymentServiceInstance = null;
    private Scanner scanner;
    
    // private Ctor to initialise
    private PaymentService(Scanner scanner)
    {
        this.scanner = scanner;
    }

    // Create only one instance and handle Multithreading
    public static PaymentService getInstance(Scanner scanner)
    {
        if(paymentServiceInstance == null)
        {
            synchronized (PaymentService.class)
            {
                if(paymentServiceInstance == null)
                {
                    paymentServiceInstance = new PaymentService(scanner);
                }
            }
        }
        return paymentServiceInstance;
    }

    public void processPayment(double fee)
    {
        choosePaymentMethod(fee);
        // Choose PaymentMethod
        // Further payment logic
    }

    // Take input and choose the payment method
    public void choosePaymentMethod(double fee)
    {
        System.out.println("Total Fee: " + fee);
        System.out.println("Choose payment method: ");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. UPI");

        int choice = scanner.nextInt();

        Payment payment;
        switch(choice)
        {
            case 1:
                payment = new Payment(fee, new CashPayment());
                break;
            case 2:
                payment = new Payment(fee, new CreditCardPayment());
                break;
            case 3:
                payment = new Payment(fee, new UPIPayment());
                break;
            default:
                System.out.println("Invalid Choice! Defaulting to Cash payment.");
                payment = new Payment(fee, new CashPayment());
                break;
        }
        payment.processPayment();
    }
    
}

package payment;

public class CashPayment implements PaymentStrategy
{
    public void processPayment(double amount)
    {
        System.out.println("Processing cash payment of $" + amount);
        // Logic of Cash Payment.
    }
}

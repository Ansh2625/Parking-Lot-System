package payment;

public class Payment 
{
    private double amount;
    private PaymentStrategy paymentStrategy;
    
    // Ctor for initialisation
    public Payment(double amount, PaymentStrategy paymentStrategy)
    {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    // process the payment
    public void processPayment()
    {
        if(amount > 0)
            paymentStrategy.processPayment(amount);
        else
            System.out.println("Invalid payment amount.");
    }
}

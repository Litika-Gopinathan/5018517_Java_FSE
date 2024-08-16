
// Adapter class for Square
public class GPayAdapter implements PaymentProcessor {
    private GPay gpay;

    public GPayAdapter(GPay gpay) {
        this.gpay = gpay;
    }

    @Override
    public void processPayment(double amount) {
        gpay.makePayment(amount);
    }
}

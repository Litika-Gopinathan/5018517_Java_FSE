
// Adapter class for Stripe
public class PaytmAdapter implements PaymentProcessor {
    private Paytm paytm;

    public PaytmAdapter(Paytm paytm) {
        this.paytm = paytm;
    }

    @Override
    public void processPayment(double amount) {
        paytm.makePayment(amount);
    }
}

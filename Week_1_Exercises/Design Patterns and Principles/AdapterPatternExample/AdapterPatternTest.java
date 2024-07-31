
public class AdapterPatternTest {
    public static void main(String[] args) {
        // PayPal payment
        PayPal payPal = new PayPal();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        payPalProcessor.processPayment(105.00);

        // Stripe payment
        Paytm stripe = new Paytm();
        PaymentProcessor stripeProcessor = new PaytmAdapter(stripe);
        stripeProcessor.processPayment(999.00);

        // Square payment
        GPay square = new GPay();
        PaymentProcessor squareProcessor = new GPayAdapter(square);
        squareProcessor.processPayment(707.00);
    }
}


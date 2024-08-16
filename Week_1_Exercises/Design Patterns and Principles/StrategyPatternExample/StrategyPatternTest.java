
public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Using Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(250.00);

        // Using PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("user@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(100.00);
    }
}


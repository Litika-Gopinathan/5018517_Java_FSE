
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Basic Email notification
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello via Email");      
     
        // Email + SMS notification
        Notifier emailAndSmsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSmsNotifier.send("Hello via Email and SMS");

        // Email + SMS + Slack notification
        Notifier emailSmsSlackNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        emailSmsSlackNotifier.send("Hello via Email, SMS, and Slack");
    }
}


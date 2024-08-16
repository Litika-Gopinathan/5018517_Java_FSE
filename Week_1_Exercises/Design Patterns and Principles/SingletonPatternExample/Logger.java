
public class Logger {
    // Private static instance of the class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize any resources required for logging
    }

    // Public static method to get the single instance of the class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

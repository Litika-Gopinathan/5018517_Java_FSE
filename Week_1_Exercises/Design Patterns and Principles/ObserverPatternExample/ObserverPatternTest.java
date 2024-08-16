
public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        System.out.println("Setting stock price to 1000.0");
        stockMarket.setStockPrice(1000.0);

        System.out.println("Deregistering MobileApp1");
        stockMarket.deregisterObserver(mobileApp1);

        System.out.println("Setting stock price to 150.0");
        stockMarket.setStockPrice(150.0);
    }
}


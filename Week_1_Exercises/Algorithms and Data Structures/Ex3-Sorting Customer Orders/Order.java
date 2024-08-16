
public class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    
    // getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}


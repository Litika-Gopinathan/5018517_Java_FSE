
public class Driver3 {
	public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "ABC", 250.50),
            new Order(2, "DEF", 1500.75),
            new Order(3, "GHI", 30.99),
            new Order(4, "JKL", 100.00),
            new Order(5, "MNO", 2020.25)
        };

        // Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("Bubble Sorted Orders by totalPrice:\n");
        for (Order order : orders) {
            System.out.println(order);
        }
        
        System.out.println();

        // Quick Sort
        orders = new Order[]{
            new Order(1, "ABC", 250.50),
            new Order(2, "DEF", 1500.75),
            new Order(3, "GHI", 300.99),
            new Order(4, "JKL", 100.00),
            new Order(5, "MNO", 2020.25)
        };

        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("Quick Sorted Orders by totalPrice:\n");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

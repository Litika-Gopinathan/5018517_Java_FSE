
public class LinearSearch {
    public static Product linearSearch(Product[] products, String productName) {
        for (Product prod : products) {
            if (prod.getProductName().equalsIgnoreCase(productName)) {
                return prod;
            }
        }
        return null;
    }
}


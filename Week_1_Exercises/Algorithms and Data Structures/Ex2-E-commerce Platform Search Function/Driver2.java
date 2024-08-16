
public class Driver2 {
	public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Home Appliances"),
            new Product(4, "Blender", "Home Appliances"),
            new Product(5, "Tablet", "Electronics")
        };

        // Linear Search
        Product result = LinearSearch.linearSearch(products, "Blender");
        System.out.println(result != null ? "Found: " + result : "Product not found.");

        // Binary Search
        result = BinarySearch.binarySearch(products, "Blend");
        System.out.println(result != null ? "Found: " + result : "Product not found.");
    }
}

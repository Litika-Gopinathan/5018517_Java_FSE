
import java.util.HashMap;

public class InventoryManagementSystem {
    private HashMap<Integer, Product> inv;

    public InventoryManagementSystem() {
        inv = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (inv.containsKey(product.getProductId())) {
            System.out.println("Product already exists.");
        } else {
            inv.put(product.getProductId(), product);
            System.out.println("Product " + product.getProductName() + " added.");
        }
    }

    public void updateProduct(int productId, String productName, Integer quantity, Double price) {
        if (inv.containsKey(productId)) {
            Product product = inv.get(productId);
            if (productName != null) {
                product.setProductName(productName);
            }
            if (quantity != null) {
                product.setQuantity(quantity);
            }
            if (price != null) {
                product.setPrice(price);
            }
            System.out.println("Product " + productId + " updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inv.containsKey(productId)) {
            inv.remove(productId);
            System.out.println("Product " + productId + " deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product getProduct(int productId) {
        return inv.getOrDefault(productId, null);
    }
}

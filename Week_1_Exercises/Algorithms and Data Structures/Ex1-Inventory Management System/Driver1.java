
public class Driver1 {
	public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Adding products
        Product product1 = new Product(1, "Shampoo", 1000, 10.99);
        Product product2 = new Product(2, "Conditioner", 500, 15.99);
        ims.addProduct(product1);
        ims.addProduct(product2);

        // Updating a product
        ims.updateProduct(1, null, 150, null);

        // Deleting a product
        ims.deleteProduct(2);

        // Retrieving a product
        System.out.println(ims.getProduct(1));
        System.out.println(ims.getProduct(2));
    }
}

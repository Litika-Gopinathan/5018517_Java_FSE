
public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the CustomerService to find a customer
        Customer customer = customerService.getCustomerById(1);
        if (customer != null) {
            System.out.println("Customer found: " + customer.getName() + ", ID: " + customer.getId());
        } else {
            System.out.println("Customer not found.");
        }
    }
}


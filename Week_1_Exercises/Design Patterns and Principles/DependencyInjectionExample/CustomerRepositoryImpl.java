
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // In a real application, this might fetch data from a database.
        // Here, we're just simulating with a hardcoded example.
        if (id == 1) {
            return new Customer("John Doe", 1);
        } else {
            return null; // Simulating customer not found
        }
    }
}


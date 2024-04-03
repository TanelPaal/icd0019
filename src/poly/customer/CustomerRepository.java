package poly.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private static final String FILE_PATH = "src/poly/customer/data.txt";

    private List<AbstractCustomer> customers = new ArrayList<>();

    public Optional<AbstractCustomer> getCustomerById(String id) {
        throw new RuntimeException("not implemented yet");
    }

    public void remove(String id) {
        throw new RuntimeException("not implemented yet");
    }

    public void save(AbstractCustomer customer) {
        throw new RuntimeException("not implemented yet");
    }

    public int getCustomerCount() {
        throw new RuntimeException("not implemented yet");
    }
}

package poly.customer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CustomerRepository {

    private static final String FILE_PATH = "src/poly/customer/data.txt";

    private List<AbstractCustomer> customers = new ArrayList<>();

    public CustomerRepository() {
        loadFromFile();
    }

    public Optional<AbstractCustomer> getCustomerById(String id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    public void remove(String id) {
        customers.removeIf(customer -> customer.getId().equals(id));
        updateFile();
    }

    public void save(AbstractCustomer customer) {
        this.remove(customer.getId());
        customers.add(customer);
        updateFile();
    }

    public int getCustomerCount() {
        return customers.size();
    }

    private void loadFromFile() {
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            lines.forEach(line -> {
                AbstractCustomer customer = createCustomer(line);
                customers.add(customer);
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to load customers from file", e);
        }
    }

    private AbstractCustomer createCustomer(String line) {
        String[] parts = line.split(";");
        String type = parts[0];
        String id = parts[1];
        String name = parts[2];
        int bonusPoints = Integer.parseInt(parts[3]);

        if ("GOLD".equals(type)) {
            return new GoldCustomer(id, name, bonusPoints);
        } else {
            LocalDate expiryDate = LocalDate.parse(parts[4]);
            return new RegularCustomer(id, name, bonusPoints, expiryDate);
        }
    }

    private void updateFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(String.join("\n", customers.stream().map(AbstractCustomer::asString).toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package poly.customer;

public class BonusCollector {

    private CustomerRepository repository;

    public BonusCollector(CustomerRepository repository) {
        this.repository = repository;
    }

    public void gatherCustomerBonus(String customerId, Order order) {

        repository.getCustomerById(customerId).ifPresent(customer -> {

            customer.collectBonusPointsFrom(order);

            repository.save(customer);
        });
    }


}

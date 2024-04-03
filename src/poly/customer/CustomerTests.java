package poly.customer;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTests {

    private final BonusCollector collector = new BonusCollector(new CustomerRepository());

    @Test
    public void noBonusForSmallOrders() {

        Integer pointsBefore = getPointsFor("c1");

        collector.gatherCustomerBonus("c1", new Order(10, currentDate()));

        assertThat(getPointsFor("c1"), is(pointsBefore));
    }

    @Test
    public void goldCustomerGetsPointsForOrdersOver100() {
        Integer pointsBefore = getPointsFor("c3");

        collector.gatherCustomerBonus("c3", new Order(200, currentDate()));

        assertThat(getPointsFor("c3"), is(pointsBefore + 300));
    }

    @Test
    public void regularCustomerGetsPointsForOrdersOver100() {
        Integer pointsBefore = getPointsFor("c2");

        collector.gatherCustomerBonus("c2", new Order(200, currentDate()));

        assertThat(getPointsFor("c2"), is(pointsBefore + 200));
    }

    @Test
    public void regularCustomerGetsMorePointsForFrequentOrders() {
        Integer pointsBefore = getPointsFor("c1");

        collector.gatherCustomerBonus("c1", new Order(200, currentDate()));

        assertThat(getPointsFor("c1"), is(pointsBefore + 300));
    }

    private Integer getPointsFor(String id) {
        return new CustomerRepository().getCustomerById(id)
                .map(AbstractCustomer::getBonusPoints)
                .orElseThrow(() -> new IllegalArgumentException("unknown id: " + id));
    }

    private LocalDate currentDate() {
        return LocalDate.parse("2024-04-03");
    }
}

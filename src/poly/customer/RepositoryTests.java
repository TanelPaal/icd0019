package poly.customer;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;

public class RepositoryTests {

    @Test
    public void canAddCustomers() {
        String randomId = UUID.randomUUID().toString();

        RegularCustomer customer = new RegularCustomer(
                randomId, "David", 0, LocalDate.now());

        getRepository().save(customer);

        assertThat(getRepository().getCustomerById(randomId).get(), is(customer));
    }

    @Test
    public void canDeleteCustomers() {
        RegularCustomer customer = new RegularCustomer(
                "c4", "David", 0, LocalDate.now());

        getRepository().save(customer);

        getRepository().remove("c4");

        assertFalse(getRepository().getCustomerById("c4").isPresent());
    }

    @Test
    public void canUpdateCustomers() {

        RegularCustomer customer = new RegularCustomer(
                "c4", "David", 0, LocalDate.now());

        getRepository().save(customer);

        int countBefore = getRepository().getCustomerCount();

        getRepository().save(customer);

        assertThat(getRepository().getCustomerCount(), is(countBefore));
        assertThat(getRepository().getCustomerById("c4").get(), is(customer));
    }

    @Test
    public void customerIsChangedOnlyWhenSaved() {
        String randomId = UUID.randomUUID().toString();

        getRepository().save(new RegularCustomer(
                randomId, "David", 0, LocalDate.now()));

        AbstractCustomer customer = getRepository().getCustomerById(randomId).get();

        assertThat(customer.getBonusPoints(), is(0));

        customer.collectBonusPointsFrom(new Order(200, LocalDate.now()));

        assertThat(customer.getBonusPoints(), is(not(0)));

        AbstractCustomer loaded = getRepository().getCustomerById(randomId).get();

        assertThat(loaded.getBonusPoints(), is(0));
    }

    private CustomerRepository getRepository() {
        return new CustomerRepository();
    }

    @Test
    public void repositoryShouldNotUseStaticFields() {
        List<Field> fieldsNotAllowed = Arrays.stream(CustomerRepository.class.getDeclaredFields())
                .filter(field -> isStatic(field.getModifiers()))
                .filter(field -> !"FILE_PATH".equals(field.getName()))
                .toList();

        assertThat(fieldsNotAllowed, is(empty()));
    }

    private boolean isStatic(int modifierValue) {
        return (modifierValue & Modifier.STATIC) > 0;
    }
}

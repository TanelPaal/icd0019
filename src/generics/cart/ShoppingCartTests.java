package generics.cart;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTests {

    @Test
    public void canGetCartTotal() {

        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.add(new Product("p1", 10.0));
        cart.add(new Product("p2", 5.0));

        assertThat(cart.getTotal(), is(closeTo(15)));
    }

    @Test
    public void canStoreServicesToo() {

        ShoppingCart<Service> cart = new ShoppingCart<>();

        cart.add(new Service("s1", 3.0));
        cart.add(new Service("s2", 2.0));

        assertThat(cart.getTotal(), is(closeTo(5)));
    }

    @Test
    public void canRemoveItemsFromCart() {

        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.add(new Product("p1", 10.0));

        cart.removeById("p1");

        assertThat(cart.getTotal(), is(closeTo(0)));
    }

    @Test
    public void canAddMultipleItemsAtOnce() {

        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.addAll(List.of(
                new Product("p1", 10.0),
                new Product("p2", 2.0)));

        assertThat(cart.getTotal(), is(closeTo(12)));
    }

    @Test
    public void cartHasStringRepresentation() {

        ShoppingCart<Service> cart = new ShoppingCart<>();

        cart.add(new Service("s1", 3.0));
        cart.add(new Service("s2", 2.0));

                                     // (identifier, price, quantity), ...
        assertThat(cart.toString(), is("(s1, 3.0, 1), (s2, 2.0, 1)"));
    }

    @Test
    public void canIncreaseQuantityById() {

        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.add(new Product("p1", 5.0));
        cart.add(new Product("p2", 10.0));

        cart.increaseQuantity("p2");

        assertThat(cart.getTotal(), is(closeTo(25)));
        assertThat(cart.toString(), is("(p1, 5.0, 1), (p2, 10.0, 2)"));
    }

    @Test
    public void addingTheSameProductAgainIncreasesItsQuantity() {

        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.add(new Product("p1", 5.0));
        cart.add(new Product("p1", 5.0));

        assertThat(cart.getTotal(), is(closeTo(10)));
        assertThat(cart.toString(), is("(p1, 5.0, 2)"));
    }

    @Test
    public void canAddDiscountToWholeCart() {
        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.add(new Product("p1", 10.0));

        cart.applyDiscountPercentage(10.0);

        assertThat(cart.getTotal(), is(closeTo(9)));
        assertThat(cart.toString(), is("(p1, 10.0, 1)"));
    }

    @Test
    public void canAddMultipleDiscounts() {
        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.add(new Product("p1", 10.0));

        cart.applyDiscountPercentage(10.0);

        cart.applyDiscountPercentage(10.0);

        assertThat(cart.getTotal(), is(closeTo(8.1)));
        assertThat(cart.toString(), is("(p1, 10.0, 1)"));
    }

    @Test
    public void canRemoveLastDiscount() {
        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.add(new Product("p1", 10.0));

        cart.applyDiscountPercentage(10.0);

        cart.applyDiscountPercentage(8.0);

        assertThat(cart.getTotal(), is(closeTo(8.28)));

        cart.removeLastDiscount();

        assertThat(cart.getTotal(), is(closeTo(9)));
    }

    private Matcher<Double> closeTo(double value) {
        double precision = 0.001;

        return Matchers.closeTo(value, precision);
    }
}

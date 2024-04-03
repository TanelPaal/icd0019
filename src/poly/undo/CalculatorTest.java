package poly.undo;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CalculatorTest {

    @Test
    public void calculatorCanAddAndMultiply() {

        Calculator c = new Calculator();

        c.input(2);

        c.add(4);

        c.multiply(3);

        assertThat(c.getResult(), is(closeTo(18.0)));
    }

    @Test
    public void operationsCanBeUndone() {

        Calculator c = new Calculator();

        c.input(2);

        c.multiply(3);

        c.add(1);

        assertThat(c.getResult(), is(closeTo(7)));

        c.undo();

        assertThat(c.getResult(), is(closeTo(6)));

        c.undo();

        assertThat(c.getResult(), is(closeTo(2)));

        c.undo();

        assertThat(c.getResult(), is(closeTo(0)));
    }






    private Matcher<Double> closeTo(double value) {
        double precision = 0.001;

        return Matchers.closeTo(value, precision);
    }
}

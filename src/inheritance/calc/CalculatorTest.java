package inheritance.calc;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void calculatesWeeklyPayAfterIncomeTax() {
        PayCalculator calc = new PayCalculator();

        assertThat(calc.getWeeklyPayAfterTaxes(40), is(closeTo(480)));
    }

    @Test
    public void calculatesWeeklyPayWithInTaxFreeZone() {
        TaxFreePayCalculator calc = new TaxFreePayCalculator();

        assertThat(calc.getWeeklyPayAfterTaxes(40), is(closeTo(600)));
    }


    private Matcher<Double> closeTo(double value) {
        double precision = 0.1;

        return Matchers.closeTo(value, precision);
    }

}

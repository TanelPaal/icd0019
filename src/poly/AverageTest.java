package poly;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AverageTest {

    @Test
    public void computesAverageFromListOfNumbers() {

        Double result = getAverage(List.of(3.9, 4, 1.2, 0, 9, 2));

        assertThat(result, is(closeTo(3.35)));
    }

    public Double getAverage(List<? extends Number> numbers) {
        if (numbers.isEmpty()){
            return 0.0;

        }

        double sum = 0.0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum / numbers.size();
    }

    private Matcher<Double> closeTo(double value) {
        double precision = 0.001;

        return Matchers.closeTo(value, precision);
    }

}

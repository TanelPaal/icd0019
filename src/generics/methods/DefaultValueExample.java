package generics.methods;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultValueExample {

    @Test
    public void exampleWithoutHelperMethodConstantExists() {

        Integer constant = getConstantForZone("A");

        if (constant == null) {
            constant = 1; // set default value if it was null
        }

        Integer result = 100 * constant;

        assertThat(result, is(200)); // constant for zone A exists
    }

    @Test
    public void exampleWithoutHelperMethodConstantDoesNotExists() {

        Integer constant = getConstantForZone("B");

        if (constant == null) {
            constant = 1; // set default value if it was null
        }

        Integer result = 100 * constant;

        assertThat(result, is(100)); // constant for zone b does not exist
                                     // and default was used
    }

    @Test
    public void exampleWithHelperForIntegers() {

        Integer constant = defaultIfNull(getConstantForZone("A"), 1);

        assertThat(100 * constant, is(200));

        constant = defaultIfNull(getConstantForZone("B"), 1);

        assertThat(100 * constant, is(100));
    }

    @Test
    public void exampleWithHelperForDoubles() {

        Double constant = defaultIfNull(getConstantForZoneAsDouble("A"), 1.0);

        assertThat(100 * constant, is(closeTo(200)));

        constant = defaultIfNull(getConstantForZoneAsDouble("B"), 1.0);

        assertThat(100 * constant, is(closeTo(100)));

    }

    public <T> T defaultIfNull(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }





























    private Integer getConstantForZone(String key) {

        // simulates code that produces Integer for certain input

        if ("A".equals(key)) {
            return 2;
        } else {
            return null;
        }
    }

    private Double getConstantForZoneAsDouble(String key) {

        // simulates code that produces Double for certain key

        if ("A".equals(key)) {
            return 2.0;
        } else {
            return null;
        }
    }

    private Matcher<Double> closeTo(double value) {
        double precision = 0.001;

        return Matchers.closeTo(value, precision);
    }


}

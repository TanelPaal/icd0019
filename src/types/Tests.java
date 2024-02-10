package types;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tests {

    @Test
    public void calculatesSumFromArrayOfIntegers() {
        assertThat(Code.sum(new int[] {1, 3, -2, 9}), is(11));

        assertThat(Code.sum(new int[] {1, 3, 9}), is(13));

        assertThat(Code.sum(new int[] {1, 3, -2, 9, 4}), is(15));
    }

    @Test
    public void calculatesAverageFromArrayOfIntegers() {
        assertThat(Code.average(new int[] {1, 3, -2, 9}), closeTo(2.75));

        assertThat(Code.average(new int[] {1, 3, -2, 9, 5}), closeTo(3.2));

        assertThat(Code.average(new int[] {1, 2, 3, 4, 5, 6}), closeTo(3.5));
    }

    @Test
    public void findsMinimumElementFromArrayOfIntegers() {
        assertThat(Code.minimumElement(new int[] {1, 3, -2, 9}), is(-2));

        assertThat(Code.minimumElement(new int[] {1, 2, 3, 4, 5, 0}), is(0));

        assertThat(Code.minimumElement(new int[] {1}), is(1));

        assertThat(Code.minimumElement(new int[] {}), is(nullValue()));
    }

    @Test
    public void findsModeFromCharactersInString() {
        assertThat("abcb", Code.mode("abcb"), is('b'));
        assertThat("abccbc", Code.mode("abccbc"), is('c'));
        assertThat("abcacbaca", Code.mode("abcacbaca"), is('a'));
        assertThat("", Code.mode(""), is(nullValue()));
    }

    @Test
    public void squaresDigitsInString() {
        assertThat(Code.squareDigits("2"), is("4"));

        assertThat(Code.squareDigits("a2b"), is("a4b"));

        assertThat(Code.squareDigits("a22b"), is("a44b"));

        assertThat(Code.squareDigits("a9b2"), is("a81b4"));
    }

    @Test
    public void createsStringFromArray() {
        assertThat(Code.asString(new int[] { 1, 3, -2, 9 }), is("1, 3, -2, 9"));

        assertThat(Code.asString(new int[] { }), is(""));
    }

    @Test
    public void testsWhetherSquareIsIsolated() {
        assertThat(Code.isIsolated(0, 9), is(true));
        assertThat(Code.isIsolated(5, 7), is(true));

        assertThat(Code.isIsolated(0, 0), is(false));
        assertThat(Code.isIsolated(9, 9), is(false));
        assertThat(Code.isIsolated(5, 3), is(false));
        assertThat(Code.isIsolated(7, 1), is(false));
    }

    @Test
    public void findsIsolatedSquareCount() {
        assertThat(Code.isolatedSquareCount(), is(2));
    }

    private Matcher<Double> closeTo(double value) {
        double precision = 0.00001;

        return Matchers.closeTo(value, precision);
    }
}

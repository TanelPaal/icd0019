package junit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AssertTests {

    @Test
    public void testsAssertEqualsOrder() {
        assertEquals(sum(1, 2), 4);
    }

    @Test
    public void testsAssertEqualsArray() {
        int[] a = {1, 2};
        int[] b = {1, 2};

        assertEquals(a, b);
    }

    @Test
    public void testsAssertThatOrder() {
        assertThat(4, is(sum(1, 2)));
    }

    @Test
    public void testsAssertThatArray() {
        int[] a = {1, 2};
        int[] b = {1, 2};

        assertThat(a, is(b));
    }

    @Test
    public void testsAssertThatArrayWithNot() {
        int[] a = {1, 2};
        int[] b = {1, 3};

        assertThat(a, is(not(b)));
    }

    @Test
    public void testsAssertThatTypes() {
        assertThat(pow(2, 3), is(8.0));
    }


































    private int sum(int a, int b) {
        return a + b;
    }

    private Object pow(int a, int b) {
        double result = Math.pow(a, b);
        // It is not important what this code actually does.
        // This example highlights potential misunderstandings.
        // Similar appearance doesn't guarantee equivalence.
        return new Object() {
            @Override
            public String toString() {
                return String.valueOf(result);
            }
        };
    }
}

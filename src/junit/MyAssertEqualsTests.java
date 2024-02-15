package junit;

import org.junit.Test;

import java.util.Arrays;

public class MyAssertEqualsTests {

    @Test
    public void testsPrimitiveEqualitySuccess() {
        myAssertEquals(1, 1);
    }

    @Test(expected = AssertionError.class) // this test is expected to fail.
    public void testsPrimitiveEqualityFailure() {
        myAssertEquals(1, 2);
    }

    @Test
    public void testsObjectEqualitySuccess() {
        myAssertEquals(200L, 200L);
    }

    @Test(expected = AssertionError.class) // this test is expected to fail.
    public void testsObjectEqualityFailure() {
        myAssertEquals(100L, 200L);
    }

    @Test
    public void testsArrayEqualitySuccess() {
        int[] a = {1, 2};
        int[] b = {1, 2};

        myAssertEquals(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testsArrayEqualityFailure1() {
        int[] a = {1, 2};
        int[] b = {1};

        myAssertEquals(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testsArrayEqualityFailure2() {
        int[] a = {};
        int[] b = {1};

        myAssertEquals(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testsArrayEqualityFailure3() {
        int[] a = {1, 2};
        int[] b = {1, 3};

        myAssertEquals(a, b);
    }



    public void myAssertEquals(int expected, int actual) {
        if (expected != actual) {
            String message = "%s is not equal to %s"
                    .formatted(actual, expected);
            throw new AssertionError(message);
        }
    }

    public void myAssertEquals(Long expected, Long actual) {
        if (expected.equals(actual)) {
            return;
        }

        String message = "%s is not equal to %s"
                .formatted(actual, expected);
        throw new AssertionError(message);
    }

    public void myAssertEquals(int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            return;
        }
        // Arrays.equals() compares the values of two arrays.

        String message = "%s is not equal to %s"
                .formatted(Arrays.toString(expected), Arrays.toString(actual));
        // Arrays.toString() converts an array to a string.
        throw new AssertionError(message);
    }
    // Another solution
    //if (expected.length != actual.length) {
    //    throw new AssertionError(message);
    //}
    //for (int i = 0; i < expected.length; i++) {
    //    if (expected[i] != actual[i]) {
    //        throw new AssertionError(message);
    //    }
}

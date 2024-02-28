package exceptions.validate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MinimumElementTests {

    @Test
    public void findsMinimumFromArrayOfNumbers() {

        assertThat(MinimumElement.minimumElement(new int[] { 1, 3 }), is(1));

        assertThat(MinimumElement.minimumElement(new int[] { 1, 0 }), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void handlesEmptyArray() {

        MinimumElement.minimumElement(new int[] { });
    }

    @Test(expected = IllegalArgumentException.class)
    public void handlesInputNull() {

        MinimumElement.minimumElement(null);
    }


}

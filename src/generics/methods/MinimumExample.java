package generics.methods;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinimumExample {

    @Test
    public void findMinimumExample() {
        assertThat(min(1, 2), is(1));
        assertThat(min(2, 1), is(1));

        assertThat(min("a", "b"), is("a"));
        assertThat(min("b", "a"), is("a"));
    }

    public <T extends Comparable<T>> T min(T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }


}

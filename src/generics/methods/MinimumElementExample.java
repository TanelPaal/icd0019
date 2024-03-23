package generics.methods;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinimumElementExample {

    @Test
    public void findsMinimumElementFromList() {
        assertThat(minimumElement(List.of(1, 2, -5)), is(-5));

        assertThat(minimumElement(List.of("b", "a", "c")), is("a"));
    }



    public <T extends Comparable<T>> T minimumElement(List<T> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("should contain at least one element");
        }

        T minimumElement = input.get(0);

        for (T current : input) {
            if (current.compareTo(minimumElement) < 0) {
                minimumElement = current;
            }
        }

        return minimumElement;
    }

}

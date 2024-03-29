package fp.examples;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Sorting {

    @Test
    public void sortingByNaturalOrder() {
        List<Integer> numbers = List.of(5, 2, 0, 3);

        List<Integer> sorted = numbers.stream()
                .sorted()
                .toList();

        assertThat(sorted, is(List.of(0, 2, 3, 5)));
    }

    @Test
    public void sortingByCustomCriteria() {
        List<String> numbers = List.of("123", "1", "23");

        List<String> sorted = numbers.stream()
                .sorted(Comparator.comparing(each -> each.length()))
                .toList();

        assertThat(sorted, is(List.of("1", "23", "123")));
    }

    @Test
    public void sortingByCustomCriteriaWithProvidedUtilities() {
        List<String> numbers = List.of("123", "1", "23");

        List<String> sorted = numbers.stream()
                .sorted(Collections.reverseOrder(
                            Comparator.comparing(each -> each.length())))
                .toList();

        // Comparator.comparing() specifies sorting criteria
        // wrapping it with Collections.reverseOrder reverses the order

        assertThat(sorted, is(List.of("123", "23", "1")));
    }

}



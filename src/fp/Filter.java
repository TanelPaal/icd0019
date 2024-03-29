package fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Filter {

    @Test
    public void findsElementsThatMatchCondition() {

        var numbers = List.of(1, 2, 3, 4);

        assertThat(filter(numbers, x -> x > 2), is(List.of(3, 4)));

        assertThat(filter(numbers, x -> x % 2 == 0), is(List.of(2, 4)));
    }

    private List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {

        List<Integer> result = new ArrayList<>();

        for (Integer element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }

        return result;
    }
}

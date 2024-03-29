package fp.examples;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilterAndMap {

    @Test
    public void findSquaresOfPositiveNumbers() {
        List<Integer> numbers = List.of(5, -2, 0, -3, 2);

        List<Integer> result = numbers.stream()
                .filter(x -> x >= 0)
                .map(x -> x * x)
                .toList();

        assertThat(result, is(List.of(25, 0, 4)));
    }

}



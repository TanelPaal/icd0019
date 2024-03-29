package fp.examples;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Sublist {

    @Test
    public void takesSublist() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

        List<Integer> sublist = numbers.stream()
                .skip(2)
                .limit(3)
                .toList();

        assertThat(sublist, is(List.of(2, 3, 4)));
    }
}



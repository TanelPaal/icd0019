package fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Map {

    @Test
    public void transformsListElements() {

        var numbers = List.of(1, 2, 3, 4);

        assertThat(map(numbers, x -> x + 1), is(List.of(2, 3, 4, 5)));

    }

    private List<Integer> map(List<Integer> list, Function<Integer, Integer> mapper) {

        List<Integer> result = new ArrayList<>();

        for (Integer element : list) {
            result.add(mapper.apply(element));
        }
        return result;
    }
}

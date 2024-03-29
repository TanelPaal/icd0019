package fp;

import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Reduce {

    @Test
    public void reducesListToSingleResult() {

        var numbers = List.of(1, 2, 3, 4);

        assertThat(reduce(numbers, (a, b) -> a + b), is(10));

        assertThat(reduce(numbers, (a, b) -> a * b), is(24));

        assertThat(reduce(List.of("1", "2", "3"), (a, b) -> a + b), is("123"));

    }

    private <T> T reduce(List<T> list, BiFunction<T, T, T> func) {

        if (list.isEmpty()) {
            throw new RuntimeException("List is empty!");
        }

        T result = list.get(0);
        // 1, 2, 3, 4
        for (int i = 1; i < list.size(); i++) {
            result = func.apply(result, list.get(i));
        }

        return result;
    }
}

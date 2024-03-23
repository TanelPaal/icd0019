package generics.pair;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Runner {

    @Test
    public void pairExample() {
        Pair<String, Integer> pair = new Pair("key", 1);

        String key = pair.getFirst();
        Integer value = pair.getSecond();

        assertThat(key, is("key"));
        assertThat(value, is(1));
    }

    @Test
    public void pairExample1() {
        Pair<Integer, Double> pair = new Pair(1, 1.0);

        Integer key = pair.getFirst();
        Double value = pair.getSecond();

        assertThat(key, is(1));
        //assertThat(value, is(1.0));
    }
}

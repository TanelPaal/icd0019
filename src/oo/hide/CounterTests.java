package oo.hide;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CounterTests {

    @Test
    public void keepsCount() {
        Counter counter = new Counter(1, 1);

        assertThat(counter.nextValue(), is(1));
        assertThat(counter.nextValue(), is(2));
        assertThat(counter.nextValue(), is(3));
    }

    @Test
    public void keepsCountWithStep() {
        Counter counter = new Counter(1, 2);

        assertThat(counter.nextValue(), is(1));
        assertThat(counter.nextValue(), is(3));
        assertThat(counter.nextValue(), is(5));
        assertThat(counter.nextValue(), is(7));
    }


}

package oo.hide;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FibonacciTests {

    @Test
    public void keepsCount() {
        Fibonacci fib = new Fibonacci();

        assertThat(fib.nextValue(), is(0));
        assertThat(fib.nextValue(), is(1));
        assertThat(fib.nextValue(), is(1));
        assertThat(fib.nextValue(), is(2));
        assertThat(fib.nextValue(), is(3));
        assertThat(fib.nextValue(), is(5));
        assertThat(fib.nextValue(), is(8));
        assertThat(fib.nextValue(), is(13));
    }



}

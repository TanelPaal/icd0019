package inheritance.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoggingStackTest {

    @Test
    public void loggingStackLogsMethodCalls() {
        LoggingStack stack = new LoggingStack();

        stack.push(1);
        stack.push(2);

        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
        assertThat(stack.size(), is(0));
    }


    @Test
    public void canAddMultipleElementsAtOnce() {
        LoggingStack stack = new LoggingStack();

        stack.pushAll(1, 2, 3);

        assertThat(stack.size(), is(3));
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
    }



}

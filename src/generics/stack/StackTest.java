package generics.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {

    @Test
    public void elementsArePoppedInReverseOrder() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        Integer first = stack.pop();
        Integer second = stack.pop();

        assertThat(first, is(2));
        assertThat(second, is(1));
    }

    @Test
    public void elementsArePoppedInReverseOrder2() {
        Stack<Double> stack = new Stack();

        stack.push(1.0);
        stack.push(2.0);

        Double first = stack.pop();
        Double second = stack.pop();

        assertThat(first, is(2.0));
        assertThat(second, is(1.0));
    }

    @Test
    public void elementsArePoppedInReverseOrder3() {
        Stack<String> stack = new Stack();

        stack.push("1.0");
        stack.push("2.0");

        String first = stack.pop();
        String second = stack.pop();

        assertThat(first, is("2.0"));
        assertThat(second, is("1.0"));
    }

}

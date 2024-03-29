package fp.examples;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class Types {

    @Test
    public void lambdaExamples() {

        Predicate<Integer> f1 = x -> x > 2;

        assertTrue(f1.test(3));

        MyPredicate f2 = x -> x > 2;

        assertTrue(f2.check(3));

        Function<Integer, Double> f3 = x -> Math.pow(x, 2);

        assertThat(f3.apply(3), is(closeTo(9)));

        BiFunction<Integer, Integer, Double> f4 = (x, y) -> Math.pow(x, y);

        assertThat(f4.apply(3, 3), is(closeTo(27)));

        Runnable l1 = () -> System.out.println("hello!");

        l1.run();

        Consumer<String> l2 = x -> System.out.println(x);

        l2.accept("hello!");

        Consumer<String> l3 = System.out::println;

        l3.accept("hello!");

    }

    @FunctionalInterface
    private interface MyPredicate {
        boolean check(int x);
    }

    private Matcher<Double> closeTo(double value) {
        double precision = 0.0001;

        return Matchers.closeTo(value, precision);
    }


}



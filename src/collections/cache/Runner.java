package collections.cache;

import oo.hide.Timer;
import org.junit.Test;

public class Runner {

    @Test
    public void calculatesFibonacciOfN() {
        Fibonacci fib = new Fibonacci();

        Timer timer = new Timer();

        for (int i = 0; i < 41; i++) {
            System.out.println(fib.fib(i));
        }

        fib.fib(40);

        System.out.println(timer.getPassedTime());
    }

}

package oo.hide;

public class Fibonacci {

    private int current = 0;
    private int next = 1;

    public int nextValue() {
        // fib(n) = fib(n - 1) + fib(n - 2)
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        int result = current;

        // Update the values for the result iteration.
        current = next;
        next  += result;

        return result;
    }

}

package oo.hide;

public class Fibonacci {

    private int nMinus1 = 0;
    private int nMinus2 = 1;

    public int nextValue() {
        // fib(n) = fib(n - 1) + fib(n - 2)
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        int next = nMinus1;

        // Update the values for the next iteration.
        nMinus1 = nMinus2;
        nMinus2 = next + nMinus2;

        return next;
    }

}

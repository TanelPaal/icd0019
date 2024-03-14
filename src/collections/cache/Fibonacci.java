package collections.cache;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public Integer fib(Integer n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Check cache for n.
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        Integer fibN = fib(n - 1) + fib(n - 2);

        // Store the result in the cache.
        cache.put(n, fibN);

        return fibN;
    }
}

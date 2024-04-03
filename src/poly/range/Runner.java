package poly.range;

import org.junit.Test;

public class Runner {

    @Test
    public void canIterateRange() {
        for (Integer integer : range(1, 7)) {
            System.out.println(integer);
        }
    }

    private Iterable<Integer> range(int start, int end) {
        return new MyIterable(start, end);
    }
}

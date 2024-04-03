package poly.range;

import java.util.Iterator;

public class MyIterable implements Iterable<Integer> {

    private final int start;
    private final int end;

    public MyIterable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(start, end);
    }
}
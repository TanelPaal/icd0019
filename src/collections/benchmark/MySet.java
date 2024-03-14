package collections.benchmark;

import java.util.*;

public class MySet implements Set<Integer> {

    private List<Integer> data = new ArrayList<>();

    @Override
    public boolean add(Integer integer) {
        if (!data.contains(integer)) {
            return data.add(integer);
        }

        return false;
    }
































    @Override
    public int size() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean remove(Object o) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void clear() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean isEmpty() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean contains(Object o) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public Iterator<Integer> iterator() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public Object[] toArray() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new RuntimeException("not implemented");
    }

}

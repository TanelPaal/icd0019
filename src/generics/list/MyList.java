package generics.list;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {

    private final List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }

    public void addAll(List<? extends T> newElements) {
        elements.addAll(newElements);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}

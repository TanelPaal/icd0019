package poly.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListInterfaceExample {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);

        data = List.of(1, 3, 45);

        System.out.println(average(data));
    }

    private static Double average(List<Integer> elements) {
        return elements.stream()
                .mapToDouble(e -> e)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("should not be empty"));
    }

    private static void doSomethingLinkedListSpecific(LinkedList<Integer> list) {

        list.pop();

        list.getLast();

        list.listIterator(3);

        // ...

    }

}

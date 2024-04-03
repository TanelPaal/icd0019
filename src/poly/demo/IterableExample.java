package poly.demo;

import java.util.List;

public class IterableExample {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2);

        for (Integer each : integers) {
            System.out.println(each);
        }

    }

}

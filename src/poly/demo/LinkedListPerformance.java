package poly.demo;

import java.util.LinkedList;
import java.util.List;

public class LinkedListPerformance {

    public static void main(String[] args) {

        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i < 1e5; i++) {
            integers.add(i);
        }

        Timer timer = new Timer();
        for (int i = 0; i < 1e5; i++) {
            integers.remove(0);
        }
        System.out.println(timer.getPassedTime());

    }
}

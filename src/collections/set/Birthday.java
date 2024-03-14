package collections.set;

import org.junit.Test;

import java.util.*;


public class Birthday {

    @Test
    public void runCode() {

        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            counts.add(findFirstCollision());
        }

        int sum = 0;
        for (int count : counts) {
            sum += count;
        }

        System.out.println("Average number of iterations till first collision: " + (sum / counts.size()));
    }

    private int findFirstCollision() {
        Random r = new Random();


        Set<Integer> birthdays = new HashSet<>();

        for (int i = 0; i < 365; i++) {
            int randomDayOfYear = r.nextInt(365);

            if (birthdays.contains(randomDayOfYear)) {
                return i;
            } else {
                birthdays.add(randomDayOfYear);
            }
        }

        throw new IllegalStateException("No collision found after 365 iterations!");
    }

}

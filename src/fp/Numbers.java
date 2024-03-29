package fp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers = List.of(1, 3, 4, 51, 24, 5);

    @Test
    public void findsOddNumbers() {

        List<Integer> oddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0)
                .toList();

        System.out.println(oddNumbers);
    }

    @Test
    public void findsOddNumbersOver10() {

        List<Integer> oddNumbersOver10 = numbers.stream()
                .filter(number -> number % 2 != 0 && number > 10)
                .toList();

        System.out.println(oddNumbersOver10);

    }

    @Test
    public void findsSquaredOddNumbers() {

        List<Integer> squaredOddNumbers = numbers.stream()
                .filter(number -> number % 2 == 1)
                .map(number -> number * number)
                .toList();

        System.out.println(squaredOddNumbers);
    }

    @Test
    public void findsSumOfOddNumbers() {

        Integer sum = numbers.stream()
                .filter(number -> number % 2 == 1)
                .mapToInt(number -> number)
                .sum();

        System.out.println(sum);

    }

}

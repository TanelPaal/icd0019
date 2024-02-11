package types;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Code {

    public static void main(String[] args) {

        int[] numbers = {1, 3, -2, 9};

        System.out.println(sum(numbers)); // 11

        System.out.println(average(new int[] {1, 2})); // 1.5

        System.out.println(minimumElement(new int[] {1, 2})); // 1
        System.out.println(minimumElement(new int[] {})); // null

        System.out.println(asString(new int[] {1, 3, -2, 9})); // "1, 3, -2, 9"

        System.out.println(squareDigits("2")); // 4
        System.out.println(squareDigits("a2b")); // a4b
        System.out.println(squareDigits("a22b")); // a44b
        System.out.println(squareDigits("a9b2")); // a81b4

        System.out.println(mode("abcb")); // b
        System.out.println(mode("abccbc")); // c
        System.out.println(mode("abcacbaca")); // a
        System.out.println(mode("")); // null
    }

    public static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static double average(int[] numbers) {
        return Double.valueOf(sum(numbers)) / numbers.length;
    }

    public static Integer minimumElement(int[] integers) {
        if (integers.length == 0) {
            return null;
        }

        int min = integers[0];

        for (Integer each : integers) {
            if (each < min) {
                min = each;
            }
        }
        return min;
    }

    public static String asString(int[] elements) {
        StringBuilder result = new StringBuilder();

        for (int element : elements) {
            result.append(element).append(", ");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 2); // Remove the last comma and space.
        }

        return result.toString();
    }

    public static String squareDigits(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                int digit = Integer.parseInt(Character.toString(c));
                result.append(digit * digit);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static Character mode(String input) {
        if (input.isEmpty()) {
            return null;
        }

        int[] charCountArray = new int[256];
        for (char c : input.toCharArray()) {
            charCountArray[c]++;
        }

        int maxCount = 0;
        Character mode = input.charAt(0);
        for (Character i = 0; i < charCountArray.length; i++) {
            if (charCountArray[i] > maxCount) {
                maxCount = charCountArray[i];
                mode = i;
            }
        }

        return mode;
    }

    public static boolean isIsolated(int row, int col) {
        boolean[][] matrix = getSampleMatrix();

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol]) {
                return false;
            }
        }

        return true;
    }

    public static int isolatedSquareCount() {
        boolean[][] matrix = getSampleMatrix();

        int isolatedCount = 0;

        // count isolates squares here
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isIsolated(i, j)) {
                    isolatedCount++;
                }
            }
        }

        return isolatedCount;
    }

    private static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean[][] getSampleMatrix() {
        boolean[][] matrix = new boolean[10][10];

        Random r = new Random(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = r.nextInt(5) < 2;
            }
        }

        return matrix;
    }
}
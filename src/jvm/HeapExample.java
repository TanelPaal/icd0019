package jvm;

public class HeapExample {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        first(numbers);
    }

    private static int first(int[] param) {
        return param[0];
    }



}

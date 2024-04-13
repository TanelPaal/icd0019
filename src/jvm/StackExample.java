package jvm;

public class StackExample {

    public static void main(String[] args) {
        int x = 0;

        calculate(x);
    }

    private static int calculate(int param) {
        int y = 1;

        return square(param + y);
    }

    private static int square(int param) {
        return param * param;
    }


}

package types;

public class Overload {

    public static void main(String[] args) {
        System.out.println(add(1, 2)); // 3
        System.out.println(add(9223372036854775805L, 2)); // 9223372036854775807
        System.out.println(add("3", "5")); // 8
    }

    public static long add(long x, long y) {
        System.out.println("Adding longs");
        return x + y;
    }

    public static int add(int x, int y) {
        System.out.println("Adding integers");
        return x + y;
    }

    public static long add(String x, String y) {
        System.out.println("Adding numbers from strings");
        return Long.parseLong(x) + Long.parseLong(y);
    }

}

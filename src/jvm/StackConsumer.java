package jvm;

public class StackConsumer {

    public static void main(String[] args) {
        System.out.println(sumToN(20_000)); // 10_000 vs 20_000 -Xss2M
    }

    private static double sumToN(int n) {
        if (n <= 0) {
            return 1;
        }

        return n + sumToN(n - 1);
    }
}

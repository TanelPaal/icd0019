package intro;

public class Program {

    public static void main(String[] args) {

       int integer = asInteger("11001101");

        System.out.println(integer); // 205
        System.out.println(asBinaryString(205)); // "11001101"
    }

    public static String asBinaryString(int input) {
        // 205 -> "11001101"

        String result = "";
        while (input > 0) {
            if (input % 2 == 1) {
                result = '1' + result;
            }
            else {
                result = '0' + result;
            }
            input /= 2;
        }
        return result;
    }

    public static int asInteger(String input) {
        // "11001101"

        int result = 0;
        String reversed = reverse(input);

        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (reversed.charAt(i) == '1') {
                result += pow(2, i);
            }
        }
        return result;
    }

    private static int pow(int arg, int power) {
        // Java has Math.pow() but this time write your own implementation.

        if (power == 0) {
            return 1;
        }
        else {
            int result = 1;
            for (int i = 0; i < power; i++) {
                result *= arg;
            }
            return result;
        }
    }

    private static String reverse(String input) {
        String reversed = "";
        for (int i = 0; i < input.length(); i++) {
            reversed += input.charAt(input.length() - 1 - i);
        }
        return reversed;
    }
}

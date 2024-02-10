package types;

public class Performance {

    public static void main(String[] args) {

        double start = System.currentTimeMillis();

        double r = 0;
        for (int i = 0; i < 1e8; i++) {
            r += (float) i / 2;
//            r += Float.valueOf(i) / 2;
        }

        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

}

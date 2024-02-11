package types;

public class Performance2 {

    public static void main(String[] args) {

        double start = System.currentTimeMillis();

        for (int i = 0; i < 1e9; i++) {
            i += 0;
        }

        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

}

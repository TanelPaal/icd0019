package exceptions.demo;

public class Cascade {

    public static void main(String[] args) {
        calculate();
    }

    private static void calculate() {
        fetchData();
    }

    private static void fetchData() {
        readFileHelper();
    }

    private static void readFileHelper() {
        // throw new IOException("error reading file");
    }


}
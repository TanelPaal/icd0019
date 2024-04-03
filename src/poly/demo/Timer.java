package poly.demo;

public class Timer {

    private Long start = System.currentTimeMillis();

    public String getPassedTime() {
        double passedMills = System.currentTimeMillis() - start;
        return "%s sek".formatted(passedMills / 1000);
    }
}

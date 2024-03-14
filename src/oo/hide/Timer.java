package oo.hide;

public class Timer {

    private Long start = System.currentTimeMillis();

    public String getPassedTime() {
        double passedMills = System.currentTimeMillis() - start;
        return String.format("%s seconds", passedMills / 1000);
    }
}

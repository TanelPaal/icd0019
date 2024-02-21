package oo.hide;

public class Timer {

    private long startTime;

    public Timer() {
        this.startTime = System.currentTimeMillis();
    }

    public String getPassedTime() {

        long endTime = System.currentTimeMillis();
        double duration = endTime - startTime;

        return String.format("%s", duration / 1000);
    }
}

package oo.hide;

import org.junit.Test;

public class Runner {

    @Test
    public void timerExample() {

        Timer timer = new Timer();

        for (int i = 0; i < 1E8; i++) {
        }

        System.out.println(timer.getPassedTime());
    }



}

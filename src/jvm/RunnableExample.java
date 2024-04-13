package jvm;

import java.util.ArrayList;
import java.util.List;

public class RunnableExample {

    public static void main(String[] args) {
        List<Runnable> runnables = new ArrayList<>();

        runnables.add(new MyTask(1));
        runnables.add(new MyTask(2));
        // ...

        for (Runnable each : runnables) {
            runInParallel(each);
        }

    }

    private static void runInParallel(Runnable each) {
        // distribute tasks between multiple threads
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            // calculate sth
        }

        public MyTask(int input) {
        }
    }

}

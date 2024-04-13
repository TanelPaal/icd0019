package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapConsumer {

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 1000; i++) {

            Thread.sleep(100L);

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 1000000; j++) {
                list.add(j);
            }
        }
    }

}

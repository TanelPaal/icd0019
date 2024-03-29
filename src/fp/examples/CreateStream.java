package fp.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SuppressWarnings("PMD.UnusedLocalVariable")
public class CreateStream {

    @Test
    public void streamCreationExamples() {

        Stream<Integer> s1 = List.of(1, 2).stream();

        Stream<Integer> s2 = Set.of(1, 2).stream();

        Stream<Integer> s3 = Arrays.stream(new Integer[] {1, 2});

        Stream<Integer> s4 = Stream.of(1, 2);

        Stream<Integer> s5 = Stream.iterate(0, n -> n + 1).limit(2);

        LongStream s6 = LongStream.of(1L, 6L);

        IntStream s7 = IntStream.range(1, 3);
    }
}



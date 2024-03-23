package generics.recursion;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RecursionTests {

    @Test
    public void pathElementsAccessExample() {

        Path path = Paths.get("a/b/c/d.txt");

        assertThat(path.getFileName().toString(), is("d.txt"));

        assertThat(path
                .getParent()
                .getFileName().toString(), is("c"));

        assertThat(path
                .getParent()
                .getParent()
                .getFileName().toString(), is("b"));

        // etc...
    }

    @Test
    public void getElementsUsingIteration() {

        Path path = Paths.get("a/b/c/d.txt");

        var elements = new Recursion().getParts(path);

        System.out.println(elements);
    }

    @Test
    public void printElementsUsingRecursion() {

        Path path = Paths.get("a/b/c/d.txt");

        new Recursion().getParts2(path);
    }

    @Test
    public void getElementsUsingRecursionAndCollectorList() {

        Path path = Paths.get("a/b/c/d.txt");

//        List<String> parts = new ArrayList<>();

        List<String> parts3 = new Recursion().getParts3(path);

        System.out.println(parts3);
    }

    @Test
    public void getElementsUsingRecursion() {

        Path path = Paths.get("a/b/c/d.txt");

        var parts = new Recursion().getParts4(path);

        System.out.println(parts);
    }
}

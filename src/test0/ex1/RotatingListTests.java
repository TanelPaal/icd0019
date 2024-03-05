package ex1;

import org.junit.Test;
import runner.NoPointsIfThisTestFails;
import runner.Points;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RotatingListTests {

    @Test
    @Points(6)
    public void elementsAreStoredInAnArray() {
        RotatingList list = new RotatingList(3);

        assertThat(list.getInternalState(), is("[0, 0, 0]"));

        list.add(1);

        assertThat(list.getInternalState(), is("[1, 0, 0]"));

        list.add(7);

        assertThat(list.getInternalState(), is("[1, 7, 0]"));

        list.add(2);

        assertThat(list.getInternalState(), is("[1, 7, 2]"));
    }

    @Test
    @Points(6)
    public void toStringDoesNotShowEmptyPositions() {
        RotatingList list = new RotatingList(10);

        assertThat(list.toString(), is("[]"));

        list.add(1);

        assertThat(list.toString(), is("[1]"));

        list.add(0);
        list.add(3);

        assertThat(list.toString(), is("[1, 0, 3]"));
    }

    @Test
    @Points(6)
    public void whenListIsFullThenStartAddingToTheBeginning() {
        RotatingList list = new RotatingList(3);

        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.getInternalState(), is("[1, 2, 3]"));

        list.add(4);

        assertThat(list.getInternalState(), is("[4, 2, 3]"));

        list.add(0);

        assertThat(list.getInternalState(), is("[4, 0, 3]"));
    }

    @Test
    @Points(7)
    public void returnsElementsInAdditionOrder() {
        RotatingList list = new RotatingList(3);

        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.toString(), is("[1, 2, 3]"));

        list.add(4);

        assertThat(list.toString(), is("[2, 3, 4]"));

        list.add(2);

        assertThat(list.toString(), is("[3, 4, 2]"));
    }

    @Test
    @NoPointsIfThisTestFails
    public void shouldNotUseUtilClasses() throws IOException {

        String path = "src/ex1/" + RotatingList.class.getSimpleName() + ".java";

        String source = Files.readString(Paths.get(path));

        assertThat(source, not(containsString("java.util")));
    }

    @Test
    @NoPointsIfThisTestFails
    public void shouldHaveOnlyAllowedFields() {
        List<Field> fieldsNotAllowed = Arrays.stream(RotatingList.class.getDeclaredFields())
                .filter(field -> !field.getType().equals(int.class))
                .filter(field -> !field.getType().equals(Integer.class))
                .filter(field -> !field.getType().equals(int[].class))
                .toList();

        assertThat(fieldsNotAllowed, is(empty()));

        List<Field> arrayFields = Arrays.stream(RotatingList.class.getDeclaredFields())
                .filter(field -> field.getType().equals(int[].class))
                .toList();

        assertThat(arrayFields.size(), is(1));
    }
}
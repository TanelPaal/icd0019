package generics.connection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConnectionTests {

    @Test
    public void findsConnectionToDestination() {

        var finder = new ConnectionFinder();

        finder.add(new Connection("a", "b"));

        assertTrue(finder.hasConnection("a", "b"));
        assertTrue(finder.hasConnection("b", "a"));

        finder.add(new Connection("b", "c"));

        assertTrue(finder.hasConnection("a", "c"));
        assertTrue(finder.hasConnection("c", "a"));

        finder.add(new Connection("e", "f"));

        assertFalse(finder.hasConnection("a", "f"));
    }

    @Test
    public void findsConnectionToDestinationInLargeDataset() {
        var generator = new TestDataGenerator();

        var connections = generator.getConnections();

        var finder = new ConnectionFinder();
        finder.addAll(connections);

        assertTrue(finder.hasConnection("E00001", "E33522"));

        assertValidConnection("E00001", "E33522",
                finder.findConnection("E00001", "E33522"), connections);

        assertFalse(finder.hasConnection("E00001", "E33601"));


        assertTrue(finder.hasConnection("E00001", "E59799"));

        assertValidConnection("E00001", "E59799",
                finder.findConnection("E00001", "E59799"), connections);

        assertFalse(finder.hasConnection("E00001", "E59801"));
    }

    private void assertValidConnection(
            String from, String to,
            List<String> path, List<Connection> connections) {

        if (path.size() < 2) {
            throw new IllegalArgumentException("path should be at least 2 elements");
        }

        Iterator<String> iterator = path.iterator();

        String current = iterator.next();

        if (!current.equals(from)) {
            throw new AssertionError("path should start with " + from);
        }

        while (iterator.hasNext()) {
            String next = iterator.next();
            var c = TestDataGenerator.getConnection(current, next);
            if (!connections.contains(c)) {
                throw new AssertionError(String.format("connection %s does not exist", c));
            }
            current = next;
        }

        if (!Objects.equals(current, to)) {
            throw new AssertionError("path should end with " + to);
        }
    }

}

package generics.connection;

import java.util.*;

public class TestDataGenerator {

    private static final int GROUP_SIZE = 200;
    private static final int GROUP_COUNT = 400;

    private static Random random = new Random(0);

    private Set<Connection> connections = new LinkedHashSet<>();

    public List<Connection> getConnections() {

        List<List<String>> groups = new ArrayList<>();
        List<String> specialConnectors = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < GROUP_COUNT; i++) {
            List<String> group = new ArrayList<>();
            for (int j = 0; j < GROUP_SIZE; j++) {
                String name = String.format("E%05d", counter++);
                group.add(name);
            }
            groups.add(group);
            specialConnectors.add(group.get(random.nextInt(group.size())));
        }

        for (List<String> group : groups) {
            createConnectionsBetweenMembers(group);
        }

        createSpecialConnections(specialConnectors);

        return new ArrayList<>(connections);
    }

    private void createSpecialConnections(List<String> group) {
        int maxJump = GROUP_COUNT / 10;
        int i = 0;
        int lastIndex = group.size() - 1;
        while (i < lastIndex) {
            int index1 = i;
            int index2 = index1 + 1 + random.nextInt(maxJump);
            index2 = Math.min(index2, lastIndex);

            String name1 = group.get(index1);
            String name2 = group.get(index2);

            connections.add(getConnection(name1, name2));

            i = index2;
        }
    }

    private void createConnectionsBetweenMembers(List<String> group) {
        for (int i = 0; i < group.size() * 1.6; i++) {
            int index1 = random.nextInt(group.size());
            int index2 = random.nextInt(group.size());
            if (index1 == index2) {
                continue;
            }

            String name1 = group.get(index1);
            String name2 = group.get(index2);

            connections.add(getConnection(name1, name2));
        }
    }

    public static Connection getConnection(String name1, String name2) {
        return name1.compareTo(name2) < 0
                        ? new Connection(name1, name2)
                        : new Connection(name2, name1);
    }
}

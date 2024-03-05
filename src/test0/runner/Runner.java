package runner;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        new Runner().run(args[0]);
    }

    private Class<?> resolveClass(String tag) {
        Map<String, String> map = Map.of(
                "ex1", "ex1.RotatingListTests");

        if (!map.containsKey(tag)) {
            throw new IllegalStateException("unknown tag: " + tag);
        }

        return loadClass(map.get(tag));
    }

    private void run(String tag) {

        PrintStream out = System.out;
        System.err.close();

        final PointHolder pointHolder = new PointHolder();

        JUnitCore junit = new JUnitCore();
        junit.addListener(new RunListener() {
            @Override
            public void testFailure(Failure failure) {
                Points pointsAnnotation = failure.getDescription()
                        .getAnnotation(Points.class);

                if (pointsAnnotation != null) {
                    pointHolder.subtract(pointsAnnotation.value());
                }

                if (failure.getDescription()
                        .getAnnotation(NoPointsIfThisTestFails.class) != null) {
                    pointHolder.subtract(100);
                }
            }

            @Override
            public void testFinished(Description description) {
                Points annotation = description.getAnnotation(Points.class);

                if (annotation != null) {
                    pointHolder.add(annotation.value());
                    pointHolder.increaseTotal(annotation.value());
                }
            }
        });

        junit.run(resolveClass(tag));

        String pattern = "\n{0} of {1} points";

        out.println(MessageFormat.format(pattern,
                pointHolder.getPoints(), pointHolder.totalPoints));
    }

    private Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class PointHolder {
        int points = 0;
        int totalPoints = 0;

        public int getPoints() {
            return Math.max(0, points);
        }

        void add(int points) {
            this.points += points;
        }

        void increaseTotal(int points) {
            this.totalPoints += points;
        }

        void subtract(int points) {
            this.points -= points;
        }
    }
}

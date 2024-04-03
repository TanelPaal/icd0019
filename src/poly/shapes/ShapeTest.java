package poly.shapes;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShapeTest {

    @Test
    public void computesTotalArea() {

        List<Shape> shapes = List.of(
                new Circle(5), new Rectangle(2, 4), new Square(3));

        double totalArea = 0.0;

        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }

        assertThat(totalArea, is(closeTo(95.5)));
    }

    private Matcher<Double> closeTo(double value) {
        double precision = 0.1;

        return Matchers.closeTo(value, precision);
    }
}

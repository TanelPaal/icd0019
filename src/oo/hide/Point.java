package oo.hide;

import java.util.Objects;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        // Check for reference equality.
        if (this == obj) {
            return true;
        }
        // Check for null or different class.
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Cast to Point for comparison.
        Point other = (Point) obj;
        // Compare x and y values.
        return Objects.equals(x, other.x) && Objects.equals(y, other.y);
    }
}

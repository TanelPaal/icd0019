package oo.hide;

public class PointSet {
    private Point[] pointArray;
    private int pointCount;

    // Constructor with capacity parameter.
    public PointSet(int capacity) {
        pointArray = new Point[capacity];
        pointCount = 0;
    }

    // Default constructor with a default capacity of 10
    public PointSet() {
        this(10);
    }

    // Method to add a point to the set
    public void add(Point point) {
        // If the pont is already in the set, do nothing.
        if (contains(point)) {
            return;
        }
        // If the array is full, create new array with double the capacity and copy the old array to the new array.
        if (pointCount == pointArray.length) {
            Point[] newPoints = new Point[pointArray.length * 2];
            System.arraycopy(pointArray, 0, newPoints, 0, pointArray.length);
            pointArray = newPoints;
        }
        // Add the point to the array and increment the count.
        pointArray[pointCount++] = point;

    }

    // Method to return the number of points in the set.
    public int size() {
        return pointCount;
    }

    // Method to check if a point is in the set.
    public boolean contains(Point point) {
        for (int i = 0; i < pointCount; i++) {
            if (pointArray[i] == null ? point == null : pointArray[i].equals(point)) {
                return true;
            }
        }
        return false;
    }

    // Method to return a string representation of the set.
    @Override
    public String toString() {
        StringBuilder pointSetRepr = new StringBuilder();
        for (int i = 0; i < pointCount; i++) {
            if (i > 0) {
                pointSetRepr.append(", ");
            }
            pointSetRepr.append(pointArray[i]);
        }
        return pointSetRepr.toString();
    }

    // Method to check if two sets are equal.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PointSet)) {
            return false;
        }
        PointSet otherSet = (PointSet) obj;
        if (pointCount != otherSet.pointCount) {
            return false;
        }
        for (int i = 0; i < pointCount; i++) {
            if (!otherSet.contains(pointArray[i])) {
                return false;
            }
        }
        return true;
    }

    // Method to return a new set that is the difference of the current set and another set.
    public PointSet subtract(PointSet other) {
        PointSet resultSet = new PointSet(pointCount);
        for (int i = 0; i < pointCount; i++) {
            if (!other.contains(pointArray[i])) {
                resultSet.add(pointArray[i]);
            }
        }
        return resultSet;
    }

    // Method to return a new set that is the intersection of the current set and another set.
    public PointSet intersect(PointSet other) {
        PointSet resultSet = new PointSet(pointCount);
        for (int i = 0; i < pointCount; i++) {
            if (other.contains(pointArray[i])) {
                resultSet.add(pointArray[i]);
            }
        }
        return resultSet;
    }

    // Method to remove a point from the set.
    public void remove(Point point) {
        for (int i = 0; i < pointCount; i++) {
            if (pointArray[i] == null ? point == null : pointArray[i].equals(point)) {
                System.arraycopy(pointArray, i + 1, pointArray, i, pointCount - i - 1);
                pointCount--;
                return;
            }
        }
    }
}

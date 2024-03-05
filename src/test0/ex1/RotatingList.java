package ex1;

import java.util.Arrays;

public class RotatingList {

    private int[] data;
    private int size = 0;
    private int index = 0;

    public RotatingList(int capacity) {
        data = new int[capacity];
    }

    // Method to return a string representation of the current state of the array.
    public String getInternalState() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Method to add an element to the array.
    public void add(int element) {
        // If the array is not full, increment the size.
        if (size < data.length) {
            size++;
        }
        // Add the element at the current index.
        data[index] = element;
        // Move the index to the next position.
        index = (index + 1) % data.length;
    }

    // Method to rotate the array by a given number of positions.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            // Calculate the index of the element to include, wrapping around if necessary.
            int currentIndex = (index - size + i + data.length) % data.length;
            sb.append(data[currentIndex]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

package poly.undo;

import java.util.function.Function;
import java.util.Stack;

public class Calculator {

    private double value = 0.0;

    private Stack<Function<Double, Double>> undoStack = new Stack<>();

    public void input(double value) {
        double oldValue = this.value;
        undoStack.add(x -> oldValue);

        this.value = value;
    }

    public void add(double addend) {
        undoStack.add(x -> x - addend);

        value += addend;
    }

    public void multiply(double multiplier) {
        undoStack.add(x -> x / multiplier);

        value *= multiplier;
    }

    public double getResult() {
        return value;
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            throw new IllegalStateException("Nothing to undo");
        }

        value = undoStack.pop().apply(value);
    }
}

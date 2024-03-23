package generics.stack;

public class Stack<T> {

    private final Object[] elements;
    private int size = 0;

    public Stack() {
        elements = new Object[100];
    }

    public void push(T element) {
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("stack is empty");
        }

        return (T) elements[--size];
    }

}

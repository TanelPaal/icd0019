package poly.demo;

public class Node {

    private Integer data;
    private Node next;

    public Node(Integer integer, Node next) {
        this.data = integer;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", data, next);
    }
}

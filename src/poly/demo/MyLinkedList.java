package poly.demo;

public class MyLinkedList {

    private Node head;

    public void add(Integer element) {
        if (head == null) {
            head = new Node(element, null);
        } else {
            Node last = findLastNode();

            last.setNext(new Node(element, null));
        }
    }

    private Node findLastNode() {
        Node runner = head;

        while (runner.getNext() != null) {
            runner = runner.getNext();
        }

        return runner;
    }

    @Override
    public String toString() {
        return head.toString();
    }
}

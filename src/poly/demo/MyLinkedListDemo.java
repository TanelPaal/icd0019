package poly.demo;

public class MyLinkedListDemo {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        System.out.println(list);

    }
}

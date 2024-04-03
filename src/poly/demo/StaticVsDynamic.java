package poly.demo;

import java.util.List;

public class StaticVsDynamic {

    public static void main(String[] args) {
        List<A> list = List.of(new A(), new B());

        list.forEach(each -> each.aStatic());
    }

}

class A {

    public static void aStatic() {
        System.out.println("aStatic() on A");
    }

    public void aDynamic() {
        System.out.println("aDynamic() on A");
    }

}

class B extends A {

    public static void aStatic() {
        System.out.println("aStatic() on B");
    }

    public void aDynamic() {
        System.out.println("aDynamic() on B");
    }

}
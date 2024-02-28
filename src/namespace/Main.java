package namespace;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        A a1 = new A(); // classes from the same package are imported implicitly
        System.out.println(a1.getClass().getName());

        namespace.second.A a2 = new namespace.second.A(); // can use full name instead on import
        System.out.println(a2.getClass().getName());

        Integer i = 1; // classes from java.lang are imported implicitly
        System.out.println(i.getClass().getName());

        Date d = new Date(); // classes from other packages must be imported explicitly
        System.out.println(d.getClass().getName());
    }
}

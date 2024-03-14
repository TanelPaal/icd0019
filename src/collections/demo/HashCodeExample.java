package collections.demo;

import oo.hide.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashCodeExample {

    @Test
    public void hashCodeExample() {

        System.out.println("A".hashCode()); // 65

        System.out.println("AB".hashCode()); // 2081

        System.out.println("AB".hashCode()); // 2081

        System.out.println(new Object().hashCode());

        System.out.println(new Object().hashCode());
    }

    @Test
    public void listContainsExample() {

        List<Point> list = new ArrayList<>();

        list.add(new Point(1, 1));

        System.out.println(list.contains(new Point(1, 1)));
    }

    @Test
    public void setContainsExample() {

        Set<Point> set = new HashSet<>();

        set.add(new Point(1, 1));

        System.out.println(set.contains(new Point(1, 1)));
    }

}


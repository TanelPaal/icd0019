package junit;

import org.junit.Test;

public class EqualityExamples {

    @Test
    public void primitiveEquality() {
        System.out.println(1 == 1);
        System.out.println(1 == 2);
    }

    @Test
    public void objectEqualityWithSmallNumbers() {
        Integer x = 1;
        Integer y = 1;
        System.out.println(x == y);
    }

    @Test
    public void objectEqualityWithLargerNumbers() {
        Integer x = 200;
        Integer y = 200;
        System.out.println(x == y); // == compares references, not values.
    }

    @Test
    public void objectEqualityWithLargerNumbersAndEqualsMethod() {
        Integer x = 200;
        Integer y = 200;
        System.out.println(x.equals(y)); // equals compares values, not references.
    }

    @Test
    public void stringEqualityWithOptimizations() {
        System.out.println("abc" == "abc");
        System.out.println("abc" == "a" + "bc"); // Java optimizes this to "abc".
    }

    @Test
    public void stringEquality() {
        String a = "a";
        System.out.println("abc" == a + "bc"); // == compares references, not values.
        System.out.println("abc".equals(a + "bc")); // equals compares values, not references.
    }
}

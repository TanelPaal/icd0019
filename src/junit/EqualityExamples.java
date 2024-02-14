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
        System.out.println(x == y);
    }

    @Test
    public void objectEqualityWithLargerNumbersAndEqualsMethod() {
        Integer x = 200;
        Integer y = 200;
        System.out.println(x.equals(y));
    }

    @Test
    public void stringEqualityWithOptimizations() {
        System.out.println("abc" == "abc");
        System.out.println("abc" == "a" + "bc");
    }

    @Test
    public void stringEquality() {
        String a = "a";
        System.out.println("abc" == a + "bc");
        System.out.println("abc".equals(a + "bc"));
    }
}

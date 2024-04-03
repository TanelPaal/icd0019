package poly;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import poly.customer.CustomerTests;
import poly.customer.RepositoryTests;
import poly.fruit.FruitTest;
import poly.shapes.ShapeTest;
import poly.undo.CalculatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FruitTest.class,
        ShapeTest.class,
        CalculatorTest.class,
        AverageTest.class,
        RepositoryTests.class,
        CustomerTests.class})
public class TestSuite {

}
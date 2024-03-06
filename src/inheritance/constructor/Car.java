package inheritance.constructor;

public class Car extends Vehicle {
    public Car() {
        System.out.println("constructing Car");

        // init car specific stuff
    }

    public Car(String regNumber) {
        System.out.println("constructing Car with number " + regNumber);

        // init car specific stuff and use constructor parameters
    }
}

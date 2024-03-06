package inheritance.constructor;

public class Raven extends Bird {
    public Raven() {
        super("black");

        System.out.println("constructing Raven");
    }
}

package inheritance.calc;

public class TaxFreePayCalculator extends PayCalculator {

    // This method overrides the getTaxRate method in the parent class to return 0.0.
    @Override
    protected Double getTaxRate() {
        return 0.0;
    }
}

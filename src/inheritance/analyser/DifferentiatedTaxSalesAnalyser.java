package inheritance.analyser;

import java.util.List;

public final class DifferentiatedTaxSalesAnalyser extends AbstractSalesAnalyser {

    // Constructor.
    public DifferentiatedTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    // Concrete methods.
    @Override
    protected Double getTotalSales() {
        double totalSales = 0.0;
        for (SalesRecord record : records) {
            totalSales += calculateSales(record);
        }
        return totalSales;
    }
}

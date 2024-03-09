package inheritance.analyser;

import java.util.List;

public final class FlatTaxSalesAnalyser extends AbstractSalesAnalyser {

    // Constructor.
    public FlatTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    // Concrete methods.
    @Override
    protected Double getTotalSales() {
        return calculateTotalSales(records) / 1.2;
    }
}

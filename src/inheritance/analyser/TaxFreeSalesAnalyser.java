package inheritance.analyser;

import java.util.List;

public final class TaxFreeSalesAnalyser extends AbstractSalesAnalyser {

    // Constructor.
    public TaxFreeSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    // Concrete methods.
    @Override
    protected Double getTotalSales() {
        return calculateTotalSales(records);
    }

    // Concrete methods.
    @Override
    protected Double getTotalSalesByProductId(String id) {
        return calculateTotalSalesByProductId(records, id);
    }
}

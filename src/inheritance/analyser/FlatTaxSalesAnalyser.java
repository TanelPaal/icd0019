package inheritance.analyser;

import java.util.List;

public final class FlatTaxSalesAnalyser extends AbstractSalesAnalyser {

    public FlatTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double getTotalSales() {
        return calculateTotalSales(records) / 1.2;
    }

    @Override
    protected Double getTotalSalesByProductId(String id) {
        return calculateTotalSalesByProductId(records, id) / 1.2;
    }
}

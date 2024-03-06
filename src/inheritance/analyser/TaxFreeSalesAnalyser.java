package inheritance.analyser;

import java.util.List;

public final class TaxFreeSalesAnalyser extends AbstractSalesAnalyser {

    public TaxFreeSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double getTotalSales() {
        return calculateTotalSales(records);
    }

    @Override
    protected Double getTotalSalesByProductId(String id) {
        return calculateTotalSalesByProductId(records, id);
    }
}

package inheritance.analyser;

import java.util.List;

public final class DifferentiatedTaxSalesAnalyser extends AbstractSalesAnalyser {

    public DifferentiatedTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
        this.sTaxRate = 1.2;
        this.rTaxRate = 1.1;
    }

    @Override
    protected Double getTotalSales() {
        double totalSales = 0;
        for (SalesRecord record : records) {
            double taxRate = record.hasReducedRate() ? rTaxRate : sTaxRate;
            totalSales += calculateSales(record, taxRate);
        }
        return totalSales;
    }

    @Override
    protected Double getTotalSalesByProductId(String id) {
        double totalSales = 0;
        for (SalesRecord record : records) {
            if (record.getProductId().equals(id)) {
                double taxRate = record.hasReducedRate() ? rTaxRate : sTaxRate;
                totalSales += calculateSales(record, taxRate);
            }
        }
        return totalSales;
    }
}

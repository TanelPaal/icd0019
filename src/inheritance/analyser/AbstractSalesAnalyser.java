package inheritance.analyser;

import java.util.List;
import java.util.ArrayList;

public abstract sealed class AbstractSalesAnalyser
    permits DifferentiatedTaxSalesAnalyser,
            FlatTaxSalesAnalyser,
            TaxFreeSalesAnalyser {
    protected List<SalesRecord> records;
    protected double sTaxRate = 1.2;
    protected double rTaxRate = 1.1;

    // Constructor.
    public AbstractSalesAnalyser(List<SalesRecord> records) {
        this.records = records;
    }

    // Abstract methods.
    protected abstract Double getTotalSales();

    // Concrete methods.
    protected Double getTotalSalesByProductId(String id) {
        double totalSales = 0.0;
        for (SalesRecord record : records) {
            if (record.getProductId().equals(id)) {
                totalSales += calculateSales(record);
            }
        }
        return totalSales;
    }

    // Protected methods
    protected double getTaxRate() {
        return sTaxRate;
    }

    protected double getReducedTaxRate() {
        return rTaxRate;
    }

    protected double calculateSales(SalesRecord record) {
        double taxRate = record.hasReducedRate() ? getReducedTaxRate() : getTaxRate();
        double sales = record.getProductPrice() * record.getItemsSold();
        return sales / taxRate;
    }

    protected double calculateTotalSales(List<SalesRecord> records) {
        double totalSales = 0;
        for (SalesRecord record : records) {
            totalSales += record.getProductPrice() * record.getItemsSold();
        }
        return totalSales;
    }

    protected double calculateTotalSalesByProductId(List<SalesRecord> records, String id) {
        double totalSales = 0;
        for (SalesRecord record : records) {
            String currentProductID = record.getProductId();
            if (currentProductID.equals(id)) {
                totalSales += record.getProductPrice() * record.getItemsSold();
            }
        }
        return totalSales;
    }

    protected List<String> getTop3PopularItems() {
        List<String> uniqueProductIds = new ArrayList<>();
        for (SalesRecord record : records) {
            if (!uniqueProductIds.contains(record.getProductId())) {
                uniqueProductIds.add(record.getProductId());
            }
        }

        uniqueProductIds.sort((id1, id2) -> {
            int totalItemsSold1 = 0;
            int totalItemsSold2 = 0;
            for (SalesRecord record : records) {
                if (record.getProductId().equals(id1)) {
                    totalItemsSold1 += record.getItemsSold();
                }
                if (record.getProductId().equals(id2)) {
                    totalItemsSold2 += record.getItemsSold();
                }
            }
            return totalItemsSold2 - totalItemsSold1;
        });

        return uniqueProductIds.subList(0, Math.min(3, uniqueProductIds.size()));
    }

    protected String getIdOfItemWithLargestTotalSales() {
        String productIdWithLargestSales = null;
        double maxSales = 0;
        for (SalesRecord record : records) {
            double totalSales = 0;
            for (SalesRecord r : records) {
                if (r.getProductId().equals(record.getProductId())) {
                    totalSales += r.getProductPrice() * r.getItemsSold();
                }
            }
            if (totalSales > maxSales) {
                maxSales = totalSales;
                productIdWithLargestSales = record.getProductId();
            }
        }
        return productIdWithLargestSales;
    }

}



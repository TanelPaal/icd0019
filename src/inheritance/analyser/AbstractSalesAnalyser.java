package inheritance.analyser;

import java.util.List;

public abstract sealed class AbstractSalesAnalyser
    permits DifferentiatedTaxSalesAnalyser,
            FlatTaxSalesAnalyser,
            TaxFreeSalesAnalyser {
    protected List<SalesRecord> records;
    protected double sTaxRate = 1.0;
    protected double rTaxRate = 1.0;

    public AbstractSalesAnalyser(List<SalesRecord> records) {
        this.records = records;
    }

    protected abstract Double getTotalSales();

    protected abstract Double getTotalSalesByProductId(String id);


    protected double calculateSales(SalesRecord record, double taxRate) {
        double sales = record.getProductPrice() * record.getItemsSold();
        return applyTaxRate(sales, taxRate);
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

    protected double applyTaxRate(double totalSales, double taxRate) {
        return totalSales / taxRate;
    }

    protected String getIdOfMostPopularItem() {
        String mostPopularProductID = null;
        double maxItemsSold = 0;
        for (SalesRecord record : records) {
            int itemsSold = 0;
            for (SalesRecord r : records) {
                if (r.getProductId().equals(record.getProductId())) {
                    itemsSold += r.getItemsSold();
                }
            }
            if (itemsSold > maxItemsSold) {
                maxItemsSold = itemsSold;
                mostPopularProductID = record.getProductId();
            }
        }
        return mostPopularProductID;
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

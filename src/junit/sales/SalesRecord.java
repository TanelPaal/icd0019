package junit.sales;

public class SalesRecord {

    private final String productId;
    private final int productPrice;
    private final int itemsSold;

    public SalesRecord(String productId, int productPrice, int itemsSold) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.itemsSold = itemsSold;
    }

    public String getProductId() {
        return productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "productId='" + productId + '\'' +
                ", productPrice=" + productPrice +
                ", itemsSold=" + itemsSold +
                '}';
    }
}

package inheritance.analyser;

public class SalesRecord {

    private String productId;
    private Integer productPrice;
    private Integer itemsSold;
    private boolean hasReducedRate = false;

    public SalesRecord(String productId, Integer productPrice, Integer itemsSold) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.itemsSold = itemsSold;
    }

    public SalesRecord(String productId,
                       Integer productPrice,
                       Integer itemsSold,
                       boolean hasReducedRate) {
        this(productId, productPrice, itemsSold);

        this.hasReducedRate = hasReducedRate;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public Integer getItemsSold() {
        return itemsSold;
    }

    public boolean hasReducedRate() {
        return hasReducedRate;
    }
}

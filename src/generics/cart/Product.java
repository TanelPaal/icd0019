package generics.cart;

public class Product implements CartItem {
    private final String id;
    private final Double price;

    public Product(String id, Double price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}

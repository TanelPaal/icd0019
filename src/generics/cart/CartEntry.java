package generics.cart;

public class CartEntry<T extends CartItem> {
    private final T item;
    private int quantity;

    public CartEntry(T item) {
        this.item = item;
        this.quantity = 1;
    }

    public T getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }
}
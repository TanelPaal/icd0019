package generics.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends CartItem> {
    private final List<CartEntry<T>> cart = new ArrayList<>();
    private final List<Double> discounts = new ArrayList<>();


    public void add(T item) {
        for (CartEntry<T> entry : cart) {
            if (entry.getItem().getId().equals(item.getId())) {
                entry.increaseQuantity();
                return;
            }
        }
        cart.add(new CartEntry<>(item));
    }

    public void removeById(String id) {
        cart.removeIf(entry -> entry.getItem().getId().equals(id));
    }

    public Double getTotal() {
        double total = 0.0;

        for (CartEntry<T> entry : cart) {
            total += entry.getItem().getPrice() * entry.getQuantity();
        }

        for (Double discount : discounts) {
            total *= (1 - discount / 100);
        }

        return total;
    }

    public void increaseQuantity(String id) {
        for (CartEntry<T> entry : cart) {
            if (entry.getItem().getId().equals(id)) {
                entry.increaseQuantity();
            }
        }
    }

    public void applyDiscountPercentage(Double discount) {
        discounts.add(discount);
    }

    public void removeLastDiscount() {
        if (!discounts.isEmpty()) {
            discounts.remove(discounts.size() - 1);
        }
    }

    public void addAll(List<T> items) {
        for (T item : items) {
            add(item);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CartEntry<T> entry : cart) {
            sb.append("(")
                    .append(entry.getItem().getId())
                    .append(", ")
                    .append(entry.getItem().getPrice())
                    .append(", ")
                    .append(entry.getQuantity())
                    .append("), ");
        }
        return sb.toString().substring(0, sb.length() - 2);  // remove last comma and space
    }
}

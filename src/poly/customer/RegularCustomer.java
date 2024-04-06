package poly.customer;

import java.time.LocalDate;
import java.util.Objects;

public final class RegularCustomer extends AbstractCustomer {

    private LocalDate lastOrderDate;

    public RegularCustomer(String id, String name,
                           int bonusPoints, LocalDate lastOrderDate) {

        super(id, name, bonusPoints);

        this.lastOrderDate = lastOrderDate;
    }

    @Override
    public void collectBonusPointsFrom(Order order) {
        if (order.getTotal() >= 100) {
            double multiplier = 1;

            if (isOrderWithinAMonth(order)) {
                multiplier = 1.5;
            }

            this.bonusPoints += order.getTotal() * multiplier;
        }
    }

    private boolean isOrderWithinAMonth(Order order) {
        LocalDate oneMonthAgo = order.getDate().minusMonths(1);
        return lastOrderDate.isAfter(oneMonthAgo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        RegularCustomer that = (RegularCustomer) obj;
        return Objects.equals(lastOrderDate, that.lastOrderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lastOrderDate);
    }

    @Override
    public String asString() {
        return "REGULAR;" + id + ";" + name + ";" + bonusPoints + ";" + lastOrderDate;
    }

}
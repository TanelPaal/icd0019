package poly.customer;

import java.util.Objects;

public final class GoldCustomer extends AbstractCustomer {

    public GoldCustomer(String id, String name, int bonusPoints) {
        super(id, name, bonusPoints);
    }

    @Override
    public void collectBonusPointsFrom(Order order) {
        if (order.getTotal() >= 100){
            this.bonusPoints += order.getTotal() * 1.5;
        }
    }

    @Override
    public String asString() {
        return "GOLD;" + id + ";" + name + ";" + bonusPoints + ";";
    }

}
package poly.customer;

import java.time.LocalDate;

public final class RegularCustomer extends AbstractCustomer {

    public RegularCustomer(String id, String name,
                           int bonusPoints, LocalDate lastOrderDate) {

        super(id, name, bonusPoints);

        throw new RuntimeException("not implemented yet");
    }

    @Override
    public void collectBonusPointsFrom(Order order) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public String asString() {
        throw new RuntimeException("not implemented yet");
    }

}
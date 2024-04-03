package poly.customer;

import java.util.Objects;

public abstract sealed class AbstractCustomer
        permits GoldCustomer, RegularCustomer {

    protected String id;
    protected String name;
    protected int bonusPoints;

    public AbstractCustomer(String id, String name, int bonusPoints) {
        this.id = id;
        this.name = name;
        this.bonusPoints = bonusPoints;
    }

    public abstract void collectBonusPointsFrom(Order order);

    /**
     * Provides string representation of the object.
     * This string can be used for storing the object in text fail
     * @return string representation of the object.
     */
    public abstract String asString();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBonusPoints() {
        return bonusPoints;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        AbstractCustomer other = (AbstractCustomer) obj;

        return Objects.equals(id, other.id) &&
                Objects.equals(name, other.name) &&
                Objects.equals(bonusPoints, other.bonusPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bonusPoints);
    }

    @Override
    public String toString() {
        return asString();
    }

}
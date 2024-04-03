package poly.installments;

import java.time.LocalDate;

public class Installment {

    public final Integer amount;

    public final LocalDate date;

    public Installment(Integer amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("amount: %s; date: %s", amount, date);
    }
}
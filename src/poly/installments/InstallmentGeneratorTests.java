package poly.installments;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InstallmentGeneratorTests {

    @Test
    public void isSumIsLargeEnoughThenGeneratesInstallmentsForWholePeriod() {
        String actual = generateInstallments(90, "2024-04-04", "2024-06-07");
        String expected = "[30, 2024-04-04], [30, 2024-05-01], [30, 2024-06-01]";

        assertThat(actual, is(expected));
    }

    @Test
    public void whenPeriodIsTooLongThereAreNoZeroSumPayments() {
        String actual = generateInstallments(6, "2024-04-04", "2024-06-07");
        String expected = "[3, 2024-04-04], [3, 2024-05-01]";

        assertThat(actual, is(expected));
    }

    @Test
    public void remainderIsDividedBetweenLastInstallments() {
        String actual = generateInstallments(11, "2024-04-04", "2024-06-07");
        String expected = "[3, 2024-04-04], [4, 2024-05-01], [4, 2024-06-01]";

        assertThat(actual, is(expected));
    }

    @Test
    public void amountIsLessThanMinimumGivesJustOneInstallment() {
        String actual = generateInstallments(2, "2024-04-04", "2024-06-07");
        String expected = "[2, 2024-04-04]";

        assertThat(actual, is(expected));
    }

    private String generateInstallments(int amount, String start, String end) {
        InstallmentGenerator generator = new InstallmentGenerator();

        List<Installment> rows = generator.generateRowsFor(
                amount, asDate(start), asDate(end));

        return stringify(rows);
    }

    private String stringify(List<Installment> rows) {
        return rows.stream()
                .map(this::formatInstallment)
                .collect(Collectors.joining(", "));
    }

    private String formatInstallment(Installment installment) {
        return String.format("[%s, %s]",
                installment.amount,
                installment.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }

    public static LocalDate asDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
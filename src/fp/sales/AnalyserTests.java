package fp.sales;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalyserTests {

    private Analyser analyser = new Analyser(new Repository());

    @Test
    public void findsTotalSales() {
        assertThat(analyser.getTotalSales(), is(closeTo(200484.17)));
    }

    @Test
    public void findsSalesByCategory() {
        assertThat(analyser.getSalesByCategory("Office Supplies"),
                is(closeTo(56147.03)));
    }

    @Test
    public void findsSalesBetweenDates() {
        Double salesBetween = analyser.getSalesBetween(
                LocalDate.parse("2023-01-01"),
                LocalDate.parse("2023-03-31"));

        assertThat(salesBetween, is(closeTo(1488.63)));
    }

    @Test
    public void findsMostExpensiveItems() {
        assertThat(analyser.mostExpensiveItems(),
                is("OFF-BI-10003527, TEC-MA-10000822, TEC-MA-10004125"));
    }

    @Test
    public void statesWithBiggestSales() {
        assertThat(analyser.statesWithBiggestSales(),
                is("California, Texas, New York"));
    }


    private Matcher<Double> closeTo(double value) {
        double precision = 0.1;

        return Matchers.closeTo(value, precision);
    }



}

package junit.sales;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TopSalesFinderTests {

    @Test
    public void findTopSales() {

        TopSalesFinder tsf = new TopSalesFinder();
        tsf.registerSale(new SalesRecord("p1", 20, 1));
        tsf.registerSale(new SalesRecord("p2", 20, 1));
        tsf.registerSale(new SalesRecord("p2", 20, 1));
        tsf.registerSale(new SalesRecord("p1", 10, 1));
        tsf.registerSale(new SalesRecord("p3", 50, 1));

        assertThat(tsf.findItemsSoldOver(10),
                arrayContainingInAnyOrder("p1", "p2", "p3"));

        assertThat(tsf.findItemsSoldOver(39),
                arrayContainingInAnyOrder("p2", "p3"));

        assertThat(tsf.findItemsSoldOver(40),
                arrayContainingInAnyOrder("p3"));

        assertThat(tsf.findItemsSoldOver(50),
                emptyArray());
    }

    @Test
    public void canRemoveSalesRecords() {

        TopSalesFinder tsf = new TopSalesFinder();
        tsf.registerSale(new SalesRecord("p1", 5, 1));
        tsf.registerSale(new SalesRecord("p2", 20, 1));
        tsf.registerSale(new SalesRecord("p2", 10, 2));
        tsf.registerSale(new SalesRecord("p1", 4, 1));
        tsf.registerSale(new SalesRecord("p3", 50, 1));
        tsf.registerSale(new SalesRecord("p4", 2, 8));

        tsf.removeSalesRecordsFor("p2");

        assertThat(tsf.findItemsSoldOver(10),
                arrayContainingInAnyOrder("p3", "p4"));

        assertThat(tsf.findItemsSoldOver(40),
                arrayContainingInAnyOrder("p3"));

        assertThat(tsf.findItemsSoldOver(50),
                emptyArray());
    }

    @Test
    public void removeShouldNotWasteMemory() {
        TopSalesFinder tsf = new TopSalesFinder();
        for (int i = 0; i < 10_000_000; i++) {
            tsf.registerSale(new SalesRecord("p1", 20, 1));

            if (i % 100_000 == 0) {
                tsf.registerSale(new SalesRecord("p2", 1, 1));
            }

            tsf.removeSalesRecordsFor("p1");
        }

        assertThat(tsf.findItemsSoldOver(90),
                arrayContainingInAnyOrder("p2"));
    }

    @Test
    public void findTopSalesFromGeneratedData() {

        TopSalesFinder tsf = new TopSalesFinder();
        for (SalesRecord record : generateRecords(10, 10)) {
            tsf.registerSale(record);
        }

        assertThat(tsf.findItemsSoldOver(100),
                arrayContainingInAnyOrder("p1", "p3", "p4"));
    }

    @Test
    public void findTopSalesFromMoreGeneratedData() {
        TopSalesFinder tsf = new TopSalesFinder();
        for (SalesRecord record : generateRecords(100, 20)) {
            tsf.registerSale(record);
        }

        assertThat("There should be 19 items that sold over 100",
                tsf.findItemsSoldOver(100).length, is(19));

        assertThat("There should be 5 items that sold over 700",
                tsf.findItemsSoldOver(700).length, is(5));

        assertThat("Items sold over 700 are not correct",
                tsf.findItemsSoldOver(700),
                arrayContainingInAnyOrder("p5", "p6", "p11", "p14", "p15"));
    }

    private SalesRecord[] generateRecords(int recordCount, int differentProductCount) {
        SalesRecord[] records = new SalesRecord[recordCount];

        Random rand = new Random(0);
        for (int i = 0; i < recordCount; i++) {
            String id = "p" + rand.nextInt(differentProductCount);
            int price = rand.nextInt(50) + 1;
            int quantity = rand.nextInt(8) + 1;

            records[i] = new SalesRecord(id, price, quantity);
        }

        return records;
    }
}

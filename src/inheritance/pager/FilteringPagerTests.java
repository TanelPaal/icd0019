package inheritance.pager;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilteringPagerTests {

    @Test
    public void simplePagerPresentsDataInPages() {
        List<Integer> data = Arrays.asList(
                1, null, null, 2, null, 3, 4);

        SimplePager simplePager = new SimplePager(data, 3);

        assertThat(simplePager.getPage(0), contains(1, null, null));
        assertThat(simplePager.getPage(1), contains(2, null, 3));
        assertThat(simplePager.getPage(2), contains(4));

        assertThat(simplePager.hasPage(-1), is(false));
        assertThat(simplePager.hasPage(3), is(false));
    }

    @Test
    public void filteringPagerPresentsFilteredDataInPages() {
        List<Integer> data = Arrays.asList(
                1, null, null, 2,
                null, 3, 4);

        SimplePager simplePager = new SimplePager(data, 4);
        FilteringPager pager = new FilteringPager(simplePager, 2);

        assertThat(pager.getNextPage(), contains(1, 2));
        assertThat(pager.getCurrentPage(), contains(1, 2));

        assertThat(pager.getNextPage(), contains(3, 4));
        assertThat(pager.getCurrentPage(), contains(3, 4));

        assertThat(pager.getPreviousPage(), contains(1, 2));
        assertThat(pager.getCurrentPage(), contains(1, 2));
    }

    @Test(expected = IllegalStateException.class)
    public void throwsWhenNoNextPage() {
        SimplePager simplePager = new SimplePager(List.of(), 4);
        FilteringPager pager = new FilteringPager(simplePager, 2);

        pager.getNextPage();
    }

    @Test(expected = IllegalStateException.class)
    public void throwsWhenNoCurrentPage() {
        SimplePager simplePager = new SimplePager(List.of(), 4);
        FilteringPager pager = new FilteringPager(simplePager, 2);

        pager.getCurrentPage();
    }

    @Test(expected = IllegalStateException.class)
    public void throwsWhenNoPreviousPage() {
        SimplePager simplePager = new SimplePager(List.of(), 4);
        FilteringPager pager = new FilteringPager(simplePager, 2);

        pager.getPreviousPage();
    }

    @Test
    public void pagerHasTheSameBehaviourAsFilteringPagerWithMemory() {
        SimplePager simplePager = new SimplePager(getSampleInput(), 4);
        FilteringPagerWithMemory memoryPager = new FilteringPagerWithMemory(simplePager, 3);
        FilteringPager pager = new FilteringPager(simplePager, 3);

        while (memoryPager.hasNext()) {
            assertThat(pager.getNextPage(), is(memoryPager.getNextPage()));
            assertThat(pager.getCurrentPage(), is(memoryPager.getCurrentPage()));
        }

        while (memoryPager.hasPrevious()) {
            assertThat(pager.getPreviousPage(), is(memoryPager.getPreviousPage()));
            assertThat(pager.getCurrentPage(), is(memoryPager.getCurrentPage()));
        }
    }

    @Test
    public void shouldNotCallSimplePagerTooOften() {
        SimplePagerWithCounter simplePager = new SimplePagerWithCounter(getSampleInput(), 4);
        FilteringPager pager = new FilteringPager(simplePager, 3);

        for (int i = 0; i < 6; i++) {
            pager.getNextPage();
            pager.getCurrentPage();
        }

        for (int i = 0; i < 5; i++) {
            pager.getPreviousPage();
        }

        assertThat(simplePager.getPageRequestCount(), is(lessThan(100)));
    }

    @Test
    public void filteringPagerShouldHaveOnlyAllowedFields() {
        List<Field> fieldsNotAllowed = Arrays.stream(FilteringPager.class.getDeclaredFields())
                .filter(field -> !field.getType().equals(SimplePager.class))
                .filter(field -> !field.getType().equals(int.class))
                .filter(field -> !field.getType().equals(Integer.class))
                .collect(Collectors.toList());

        assertThat(fieldsNotAllowed, is(empty()));
    }

    private List<Integer> getSampleInput() {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random(0);
        for (int i = 0; i < 100; i++) {
            int randNum = random.nextInt(30);
            integers.add(randNum < 10 ? randNum : null);
        }

        return integers;
    }

}

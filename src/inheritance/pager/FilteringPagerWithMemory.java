package inheritance.pager;

import java.util.ArrayList;
import java.util.List;

public class FilteringPagerWithMemory {

    private final int pageSize;

    private int pageNumber = -1;
    public List<Integer> storage = new ArrayList<>();

    public FilteringPagerWithMemory(SimplePager dataSource, int pageSize) {
        this.pageSize = pageSize;
        for (int i = 0; dataSource.hasPage(i); i++) {
            for (Integer element : dataSource.getPage(i)) {
                if (element != null) {
                    storage.add(element);
                }
            }
        }
    }

    public boolean hasNext() {
        int pageStart = (pageNumber + 1) * pageSize;

        return pageStart < storage.size();
    }

    public boolean hasPrevious() {
        return pageNumber > 0;
    }

    public List<Integer> getNextPage() {
        if (hasNext()) {
            pageNumber++;
        } else {
            throw new IllegalStateException("there is no next page");
        }

        return getPageCommon();
    }

    public List<Integer> getCurrentPage() {
        if (pageNumber < 0) {
            throw new IllegalStateException("there is no current page");
        }

        return getPageCommon();
    }

    public List<Integer> getPreviousPage() {
        if (pageNumber <= 0) {
            throw new IllegalStateException("there is no previous page");
        } else {
            pageNumber--;
        }

        return getPageCommon();
    }

    @Override
    public String toString() {
        return String.format("page: %s", pageNumber);
    }

    private List<Integer> getPageCommon() {
        int startPos = pageNumber * pageSize;
        int endPos = Math.min(startPos + pageSize, storage.size());

        return storage.subList(startPos, endPos);
    }
}

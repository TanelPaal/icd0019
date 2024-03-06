package inheritance.pager;

import java.util.List;

public class SimplePagerWithCounter extends SimplePager {

    private int pageRequestCount = 0;

    public SimplePagerWithCounter(List<Integer> data, int pageSize) {
        super(data, pageSize);
    }

    @Override
    public List<Integer> getPage(int pageNumber) {
        pageRequestCount++;
        return super.getPage(pageNumber);
    }

    public int getPageRequestCount() {
        return pageRequestCount;
    }
}

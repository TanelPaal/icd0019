package inheritance.pager;

import java.util.List;

public class SimplePager {

    private final List<Integer> data;
    private final int pageSize;

    public SimplePager(List<Integer> data, int pageSize) {
        this.data = data;
        this.pageSize = pageSize;
    }

    public boolean hasPage(int pageNumber) {
        if (pageNumber < 0) {
            return false;
        }

        int startPos = pageNumber * pageSize;

        return startPos < data.size();
    }

    public List<Integer> getPage(int pageNumber) {
        if (!hasPage(pageNumber)) {
            throw new IllegalArgumentException("no such page: " + pageNumber);
        }

        int startPos = pageNumber * pageSize;
        int endPos = Math.min(startPos + pageSize, data.size());
        return data.subList(startPos, endPos);
    }
}

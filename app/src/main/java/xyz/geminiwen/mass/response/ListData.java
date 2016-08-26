package xyz.geminiwen.mass.response;

import java.util.List;

/**
 * Created by geminiwen on 16/8/25.
 */
public class ListData <T> {
    private List<T> rows;
    private PageModel page;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageModel getPage() {
        return page;
    }

    public void setPage(PageModel page) {
        this.page = page;
    }
}

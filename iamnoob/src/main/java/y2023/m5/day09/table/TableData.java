package y2023.m5.day09.table;

import java.util.List;

/**
 * @Author: LeahAna
 * @Date: 2023/5/9 10:01
 * @Desc:
 */

public class TableData<T> {
    private final List<String> headers;
    private final List<List<T>> rows;

    public TableData(List<String> headers, List<List<T>> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<T>> getRows() {
        return rows;
    }
}

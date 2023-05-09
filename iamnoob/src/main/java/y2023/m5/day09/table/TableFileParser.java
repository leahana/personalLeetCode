package y2023.m5.day09.table;
import java.io.InputStream;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: LeahAna
 * @Date: 2023/5/9 09:55
 * @Desc:
 */


public interface TableFileParser<T> {
    TableData<T> parse(InputStream inputStream) throws Exception;
}

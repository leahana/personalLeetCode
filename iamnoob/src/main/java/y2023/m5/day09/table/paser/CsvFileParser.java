package y2023.m5.day09.table.paser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import y2023.m5.day09.table.TableData;
import y2023.m5.day09.table.TableFileParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: LeahAna
 * @Date: 2023/5/9 09:55
 * @Desc:
 */


public class CsvFileParser<T> implements TableFileParser<T> {
    private final Class<T> type;
    private final Function<T, List<T>> rowMapper;

    public CsvFileParser(Class<T> type, Function<T, List<T>> rowMapper) {
        this.type = type;
        this.rowMapper = rowMapper;
    }
    @Override
    public TableData<T> parse(InputStream inputStream) throws Exception {
        try (Reader reader = new InputStreamReader(inputStream)) {
            // 读取CSV文件的第一行以获取表头
            CSVReader csvReader = new CSVReaderBuilder(reader).build();
            List<String> headers = Arrays.asList(csvReader.readNext());

            // 解析CSV文件的数据
            ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(type);

            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withMappingStrategy(strategy)
                    .withType(type)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<T> beans = csvToBean.parse();
            List<List<T>> rows = beans.stream().map(rowMapper).collect(Collectors.toList());

            return new TableData<>(headers, rows);
        }
    }
}

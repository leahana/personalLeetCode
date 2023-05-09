package y2023.m5.day09.table.strategy;

import org.apache.poi.ss.usermodel.Cell;
import y2023.m5.day09.table.TableData;
import y2023.m5.day09.table.TableFileParser;
import y2023.m5.day09.table.paser.CsvFileParser;
import y2023.m5.day09.table.paser.ExcelFileParser;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FileParserStrategy<T> {
    private static Map<String, TableFileParser<String>> handlerMap;

    static {
        Function<String, List<String>> csvRowMapper = Arrays::asList;
        Function<Cell, String> excelCellMapper = Cell::getStringCellValue;
        createParsers(excelCellMapper, csvRowMapper, String.class);
    }

    private static void createParsers(Function<Cell, String> excelCellMapper, Function<String, List<String>> csvRowMapper, Class<String> type) {
        Map<String, TableFileParser<String>> parsers = new HashMap<>();
        parsers.put("application/vnd.ms-excel", new ExcelFileParser<>(excelCellMapper));
        parsers.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", new ExcelFileParser<>(excelCellMapper));
        parsers.put("text/csv", new CsvFileParser<>(type, csvRowMapper));
        setHandlerMap(parsers);
    }

    public static void setHandlerMap(Map<String, TableFileParser<String>> handlerMap) {
        FileParserStrategy.handlerMap = handlerMap;
    }

    private static TableFileParser<String> getParser(String contentType) {
        return handlerMap.get(contentType);
    }

    public static TableData<String> parse(InputStream inputStream, String contentType) throws Exception {
        TableFileParser<String> parser = getParser(contentType);
        return parser.parse(inputStream);
    }

}

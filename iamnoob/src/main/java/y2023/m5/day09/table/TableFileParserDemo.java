package y2023.m5.day09.table;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import y2023.m5.day09.table.strategy.FileParserStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Slf4j
public class TableFileParserDemo {

    public static void main(String[] args) throws FileNotFoundException {

        //     parsers.put("application/vnd.ms-excel", new ExcelFileParser<>(excelCellMapper));
        //        parsers.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", new ExcelFileParser<>(excelCellMapper));
        //        parsers.put("text/csv", new CsvFileParser<>(type, csvRowMapper));
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/anshengyo/Desktop/parser-test.xlsx"));
        handleFileUpload(fileInputStream, "application/vnd.ms-excel");
    }

    // 假设这是一个文件上传处理器的方法，输入参数为文件的输入流和内容类型
    public static void handleFileUpload(InputStream inputStream, String contentType) {
        try {

            TableData<String> tableData = FileParserStrategy.parse(inputStream, contentType);

            List<String> headers = tableData.getHeaders();
            List<List<String>> rows = tableData.getRows();
            // 处理解析后的数据，例如存储到数据库或其他操作

            log.info("headers={}", headers);
            log.info("rows={}", rows);


        } catch (Exception e) {
            // 处理异常，例如记录错误或向用户显示错误消息
        }
    }


}

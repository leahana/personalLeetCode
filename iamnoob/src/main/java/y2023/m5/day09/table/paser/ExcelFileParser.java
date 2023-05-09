package y2023.m5.day09.table.paser;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import y2023.m5.day09.table.TableData;
import y2023.m5.day09.table.TableFileParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: LeahAna
 * @Date: 2023/5/9 09:56
 * @Desc:
 */

import java.util.function.Function;

public class ExcelFileParser<T> implements TableFileParser<T> {
    private final Function<Cell, T> cellMapper;

    public ExcelFileParser(Function<Cell, T> cellMapper) {
        this.cellMapper = cellMapper;
    }

    @Override
    public TableData<T> parse(InputStream inputStream) throws Exception {
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        List<String> headers = new ArrayList<>();
        List<List<T>> rows = new ArrayList<>();

        // 解析表格标题
        Row headerRow = sheet.getRow(0);
        for (Cell headerCell : headerRow) {
            headers.add(getCellStringValue(headerCell));
        }

        // 解析表格数据
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            List<T> rowData = new ArrayList<>();
            for (Cell cell : row) {
                rowData.add(cellMapper.apply(cell));
            }
            rows.add(rowData);
        }

        workbook.close();
        return new TableData<>(headers, rows);
    }

    private String getCellStringValue(Cell cell) {
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }
}

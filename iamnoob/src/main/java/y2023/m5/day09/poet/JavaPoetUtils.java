package y2023.m5.day09.poet;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LeahAna
 * @Date: 2023/5/9 09:23
 * @Desc: 读取xlsx文件 以第一列中文为注解value，第二列小驼峰为字段值 生成java类
 */

public class JavaPoetUtils {

    public static void main(String[] args) throws Exception {
        createEntitiesFromXlsx("y2023/m5/day09","/Users/anshengyo/WorkSpace/IdeaProjects/JavaProject/github/personalLeetCode/iamnoob/src/main/java/y2023/m5/day09/test.xlsx");
    }

    public static void createEntitiesFromXlsx(String packageName, String filePath) throws Exception {

        // 读取表格数据
        File file = new File(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        // 遍历所有Sheet
        for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            String sheetName = sheet.getSheetName();
            List<FieldInfo> fields = new ArrayList<>();
            // 从第1行开始读取数据
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                String column1 = cell1.getStringCellValue();
                String column2 = cell2.getStringCellValue();
                fields.add(new FieldInfo(column1, toCamelCase(column2)));
            }

            // 添加 @ETable注解
            AnnotationSpec eTableAnnotation = AnnotationSpec.builder(ETable.class)
                    .addMember("value", "\"" + sheetName + "\"")
                    .addMember("tableClass",sheetName + "Entity"+".class")

                    .build();
            // 生成实体类
            TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(sheetName + "Entity")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(eTableAnnotation);

            // 添加 @EColumn注解
            for (FieldInfo field : fields) {
                AnnotationSpec annotation = AnnotationSpec.builder(EColumn.class)
                        .addMember("value", "\"" + field.getColumn1() + "\"")
                        .build();

                FieldSpec fieldSpec = FieldSpec.builder(String.class, field.getColumn2(), Modifier.PRIVATE)
                        .addAnnotation(annotation)
                        .build();

                typeSpecBuilder.addField(fieldSpec);
            }

            TypeSpec entity = typeSpecBuilder.build();

            JavaFile javaFile = JavaFile.builder(packageName, entity)
                    .build();

//            javaFile.writeTo(System.out);
            javaFile.writeTo(new File("./"));
        }
    }

    private static class FieldInfo {
        private String column1;
        private String column2;

        public FieldInfo(String column1, String column2) {
            this.column1 = column1;
            this.column2 = column2;
        }

        public String getColumn1() {
            return column1;
        }

        public String getColumn2() {
            return column2;
        }

    }

    private static String toCamelCase(String s) {
        String[] parts = s.split("_");
        StringBuilder result = new StringBuilder(parts[0].toLowerCase());
        for (int i = 1; i < parts.length; i++) {
            result.append(parts[i].substring(0, 1).toUpperCase());
            result.append(parts[i].substring(1).toLowerCase());
        }
        return result.toString();
    }
}

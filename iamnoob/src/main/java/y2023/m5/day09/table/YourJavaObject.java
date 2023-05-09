package y2023.m5.day09.table;

import java.util.Map;

public class YourJavaObject {
    private String field1;
    private String field2;

    public YourJavaObject(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public YourJavaObject(Map<String, String> stringMap) {
        field1 = stringMap.get("field1");
        field2 = stringMap.get("field2");
    }
}

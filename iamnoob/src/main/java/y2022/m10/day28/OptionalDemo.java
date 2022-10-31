package y2022.m10.day28;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: LeahAna
 * @Date: 2022/10/28 16:05
 * @Desc: Optional工具类
 */

public class OptionalDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("demo1");
        Optional.ofNullable(list).orElse(new ArrayList());
    }

}

package y2023.m2.day27;

import cn.hutool.core.text.replacer.StrReplacer;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: LeahAna
 * @Date: 2023/2/27 10:56
 * @Desc: 入库分片
 */

public class InsertLimitDemo {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < 1234; i++) {
            Student student = new Student("name-" + i, i);
            list.add(student);
        }

        limitTest(list);

    }

    public static void limitTest(List<Student> students) {
        if (Objects.isNull(students)) return;
        int limitSize = 500;
        int count = (int) Math.ceil((double) students.size() / limitSize);
        for (int i = 0; i <= count - 1; i++) {
            if (i == count - 1) {
                List<Student> list = students.subList(i * limitSize, students.size());
                System.out.println("count-1=i");
                System.out.println("value1=" + i * limitSize + "," + "value2=" + students.size());
                //  System.out.println("dao.insert(" + list + ")");
            } else {
                System.out.println("count-1!=i,i = " + 3);
                List<Student> list = students.subList(i * limitSize, i * limitSize + limitSize);
                System.out.println("value1=" + i * limitSize + "," + "value2=" + ((i * limitSize) + limitSize));
                //   System.out.println("dao.insert(" + list + ")");
            }
        }
        System.out.println("success");
    }

}


class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

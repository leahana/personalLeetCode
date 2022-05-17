package y2022.may.day16;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: leah_ana
 * @Date: 2022/5/16 20:57
 */

public class Test {
    public static void main(String[] args) {
        Student t1 = new Student("A", 111);
        Student t2 = new Student("B", 122);
        Student t3 = new Student("D", 133);
        Student t4 = new Student("C", 144);
        List<Student> stus = new ArrayList<>();
        stus.add(t2);
        stus.add(t3);
        stus.add(t1);
        stus.add(t4);
        System.out.println(stus);

        stus.sort(Comparator.comparingInt(Student::getScore));

        System.out.println(stus);

//        TreeMap<Integer, List<Student>> collect = stus.stream().collect(Collectors.groupingBy(Student::getScore, TreeMap::new, Collectors.toList()));
//
//        System.out.println(collect);
    }
}

class Student {
    private String name;
    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

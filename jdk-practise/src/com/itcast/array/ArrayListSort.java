package com.itcast.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSort {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        // 创建学生对象
        Student student1 = new Student("xishi", 21);
        Student student2 = new Student("diaochan", 19);
        Student student3 = new Student("wangzhaojun", 20);
        Student student4 = new Student("yangyuhuan", 20);
        // 把学生添加到集合
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        Collections.reverse(students);
//        Collections.shuffle(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

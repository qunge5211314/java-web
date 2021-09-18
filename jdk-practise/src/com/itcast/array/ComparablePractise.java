package com.itcast.array;

import java.util.TreeSet;

/**
 * 存储学生对象并遍历，创建集合使用无参构造方法
 * 要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序
 */
public class ComparablePractise {
    public static void main(String[] args) {
        // 创建集合对象
        TreeSet<Student> students = new TreeSet<>();
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

        // 遍历集合
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

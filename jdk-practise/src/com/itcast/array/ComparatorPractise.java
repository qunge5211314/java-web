package com.itcast.array;


import java.util.Comparator;
import java.util.TreeSet;

/**
 * 存储学生对象并遍历，创建TreeSet集合使用带参构造方法
 * 要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母排序
 */
public class ComparatorPractise {
    public static void main(String[] args) {
        // 创建集合对象
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>(

        ) {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o1.getAge() - o2.getAge();
                return num == 0 ? o1.getName().compareTo(o2.getName()) : num;
            }
        });

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

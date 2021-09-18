package com.itcast.array;


import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student student) {
//        return 0;
//        return 1;
//        return -1;
        int num = this.age - student.getAge();
        return num == 0 ? this.name.compareTo(student.name) : num;
    }
}

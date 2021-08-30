package cn.itcast.reflect;

import cn.itcast.domain.Person;

public class ReflectDemo5 {
    /**
     * 获取类名
     */
    public static void main(String[] args) {
        Class personClass = Person.class;
        // 获取类名
        String name = personClass.getName();
        System.out.println(name); // 结果是带包的全类名
    }
}

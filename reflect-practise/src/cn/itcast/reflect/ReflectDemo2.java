package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    /**
     * 获取功能：
     * 1.获取成员变量们
     * 2.获取构造方法们
     * 3.获取成员方法们
     * 4.获取类名
     * 5.获取类注解
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 0.获取Person的Class对象
        Class personClass = Person.class;
        // 1.获取成员变量们
        Field[] fields = personClass.getFields(); // 获取所有public修饰的成员变量
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------------------------");
        Field field = personClass.getField("a"); // 获取指定名称的public修饰的成员变量
        System.out.println(field);
        System.out.println("--------------------------");
        Person person = new Person();

        field.set(person, "asd");
        Object o = field.get(person);
        System.out.println(o);
        System.out.println("--------------------------");
        Field[] declaredFields = personClass.getDeclaredFields();// 获取所有成员变量,不考虑修饰符
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("--------------------------");
        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true); // 暴力反射
        Object o1 = d.get(person);
        System.out.println(o1);


    }
}

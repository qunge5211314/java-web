package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    /**
     * 获取成员方法们
     */
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Person person = new Person();
        // 获取指定名称的方法
        Method eat1 = personClass.getMethod("eat");
        // 执行方法
        eat1.invoke(person);
        System.out.println("-------------------");
        Method eat2 = personClass.getMethod("eat", String.class);
        eat2.invoke(person, "饭");
        System.out.println("-------------------");
        // 获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
        }
    }
}

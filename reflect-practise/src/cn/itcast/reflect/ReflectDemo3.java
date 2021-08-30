package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo3 {
    /**
     * 获取构造方法们
     */
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Constructor constructor1 = personClass.getConstructor(Long.class, String.class);
        // 创建对象
        Object person1 = constructor1.newInstance(18L, "张三");
        System.out.println(person1);

        Constructor constructor2 = personClass.getConstructor();
        Object person2 = constructor2.newInstance();
        System.out.println(person2);

        Object person3 = personClass.newInstance();
        System.out.println(person3);

    }
}

package cn.itcast.reflect;

import cn.itcast.domain.Person;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

public class ReflectDemo1 {
    /**
     * 获取Class对象的方式：
     *     1.Class.forName("全类名"):将字节码文件加载进内存，返回Class对象。
     *     2.类名.class:通过类名的属性class来获取。
     *     3.对象.getClass():getClass()方法在Object中定义着。
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.Class.forName("全类名")
        Class cls1 = Class.forName("cn.itcast.domain.Person");
        System.out.println(cls1);
        // 2.类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        // 3.对象.getClass()
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);
        System.out.println(cls1==cls2 && cls1==cls3 && cls2==cls3);
    }
}

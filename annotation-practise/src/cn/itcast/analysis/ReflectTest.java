package cn.itcast.analysis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 描述需要执行的类名和方法名
 */

@Config1(className = "cn.itcast.analysis.Person", methodName = "eat")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        // 1.解析注解
        // 1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        // 2.获取上边的注解对象
        // 其实就是在内存中生成了一个该注解接口的子类实现对象
        Config1 annotation = reflectTestClass.getAnnotation(Config1.class);
        // 3.调用注解对象中定义的抽象方法，获取返回值。
        String className = annotation.className();
        String methodName = annotation.methodName();
        Class personClass = Class.forName(className);
        Method method = personClass.getMethod(methodName);
        Object o = personClass.newInstance();
        method.invoke(o);

    }
}

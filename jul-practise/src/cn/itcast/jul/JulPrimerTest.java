package cn.itcast.jul;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JulPrimerTest {
    @Test
    public void test1() {
        // JUL入门案例1
        /*
         * 日志入口程序
         * java.util.logging.Logger
         */
        // Logger对象的创建方式，不能直接new对象
        // 取得对象方法参数，需要引入当前类的全类名字符串（当前我们先这么用，以后根据包结构有Logger父子关系，以后介绍）
        Logger logger = Logger.getLogger("cn.itcast.jul.JulPrimerTest");
        /*
        对于日志输出，有两种方式：
        1、直接调用日志级别的相关方法， 方法中传递日志输出相关信息
        2、调用通用的log方法，然后在里面通过Level类型来定义日志的级别参数，以及搭配日志输出信息的参数来输出。
         */
        logger.info("这是调用Logger对象的info方法来输出的jul日志的info信息");
        logger.log(Level.INFO, "这是调用Logger对象的log通用方法来输出的jul日志的info信息");
    }

    @Test
    public void test2() {
        // JUL入门案例2
        // 创建Logger对象
        Logger logger = Logger.getLogger("cn.itcast.jul.JulTest");
        /*
        打印日志信息之动态传入数据
        案例：打印学生信息(姓名、年龄)
         */
        String name = "zhangsan";
        int age = 23;
        logger.log(Level.INFO, "学生的姓名为：" + name + ";" + "年龄为" + age);
        /*
        对于输出消息中，字符串的拼接的弊端很多
        1、麻烦
        2、效率低
        3、可读性不强
        4、维护成本高
        我们应该使用动态生成数据的方式，生成日志
        我们使用的就是占位符的方式来进行操作
         */
        logger.log(Level.INFO, "学生的姓名为{0};年龄为{1};", new Object[]{name, age});
    }

}

package cn.itcast.jul;

import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Logger间的父子关系
 * JUL中Logger是存在"父子"关系的
 * 值得注意的是，这种父子关系不是我们普遍认为的类之间的继承关系
 * 关系是通过树状结构存储的
 *
 * 总结：
 *     JUL在初始化时会创建一个顶层的RootLogger，作为所有Logger的父Logger
 *     RootLogger是LogManager的内部类
 *     RootLogger对象作为树状结构的根结点存在的
 *     将来自定义的父子关系通过路径来进行关联
 *     父子关系同时也是节点之间的挂载关系
 */
public class LoggerRelationshipTest {
    @Test
    public void loggerRelationshipTest() {
        // 日志记录器
        /*
        从下面创建的四个Logger看来
        我们可以认为logger1是logger2的父亲
         */
        Logger logger1 = Logger.getLogger("cn"); // 父亲是RootLogger,RootLogger名称默认是一个空的字符串，RootLogger可以被称之为所有Logger对象的顶层Logger
        Logger logger2 = Logger.getLogger("cn.itcast");
        // Logger logger3 = Logger.getLogger("cn.itcast.jul");
        Logger logger4 = Logger.getLogger("cn.itcast.jul.LoggerRelationshipTest");
        System.out.println(logger2.getParent() == logger1); // true
        System.out.println(logger4.getParent() == logger2); // false
        System.out.println("------------------------");
        System.out.println("logger1的父logger引用为：" + logger1.getParent() + ";logger1的父logger名称为：" + logger1.getParent().getName());
        System.out.println("logger2的父logger引用为：" + logger2.getParent() + ";logger2的父logger名称为：" + logger2.getParent().getName());
        /*
         父子关系的好处：
            父亲所做的设置，也能够作用于儿子
            对logger1做日志打印的相关设置，然后我们使用logger2进行日志的打印
         */
        // 父亲做设置
        logger1.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger1.setLevel(Level.CONFIG);
        consoleHandler.setLevel(Level.CONFIG);
        logger1.addHandler(consoleHandler);

        // 儿子做输出
        logger2.severe("severe信息");
        logger2.warning("warning信息");
        logger2.info("info信息");
        logger2.config("config信息");
        logger2.fine("fine信息");
        logger2.finer("finer信息");
        logger2.finest("finest信息");


    }
}

package cn.itcast.slf4j;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j动态打印日志信息功能实现
 */
public class Slf4jDynamicLogTest2 {
    @Test
    public void sf4jDynamicLog() {
        Logger logger = LoggerFactory.getLogger(Slf4jDynamicLogTest2.class);
        String name = "zhangsan";
        Integer age = 15;
        logger.info("学生信息---姓名：" + name + "; 年龄：" + age);
        logger.info("学生信息---姓名：{}; 年龄：{}", new Object[]{name, age});
    }
}

package cn.itcast.jul;

import org.junit.Test;

import java.util.logging.*;

/**
 * 自定义日志级别测试
 */
public class CustomLogLevelTest {
    @Test
    public void customLogLevelTest(){
        // 日志记录器
        Logger logger = Logger.getLogger("cn.itcast.jul.CustomLogLevelTest");
        // 关闭默认日志记录级别
        // 参数设置为false，我们打印日志的方式就不会按照父logger默认的方式去进行
        logger.setUseParentHandlers(false);
        // 处理器Handler
        // 在此我们使用的是控制台日志处理器, 取得处理器对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 创建日志格式化组件对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 在处理器中设置输出格式
        consoleHandler.setFormatter(simpleFormatter);
        // 在记录器中添加处理器
        logger.addHandler(consoleHandler);
        // 设置日志的打印级别
        // 此处必须将日志记录器和处理器的级别进行统一的设置，才会达到日志显示相应级别的效果。
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.info("info信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");

    }
}

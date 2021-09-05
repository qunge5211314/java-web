package cn.itcast.jul;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * 同时添加多个处理器
 */
public class MultiHandlerTest {
    @Test
    public void multiHandlerTest() throws IOException {
        // 日志记录器
        Logger logger = Logger.getLogger("cn.itcast.jul.CustomLogLevelTest");
        logger.setUseParentHandlers(false);
        // 文件日志处理器
        FileHandler fileHandler = new FileHandler("./log_to_file.log");
        // 控制台日志处理器
        ConsoleHandler consoleHandler = new ConsoleHandler();
        Formatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        consoleHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);

        logger.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.info("info信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");

        /*
        总结：用户使用Logger来进行的日志记录，Logger可以持有多个处理器Handler
        日志的记录使用的Logger，日志的输出使用的Handler
        添加了哪些Handler对象，就相当于需要根据所添加的handler将日志输出到指定位置，例如控制台、文件中等
         */
    }
}

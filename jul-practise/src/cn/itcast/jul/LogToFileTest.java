package cn.itcast.jul;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * 将日志输出到具体的文件中
 * 这样做是相当于做了日志的持久化操作
 */
public class LogToFileTest {
    @Test
    public void logToFileTest() throws IOException {
        // 日志记录器
        Logger logger = Logger.getLogger("cn.itcast.jul.CustomLogLevelTest");
        logger.setUseParentHandlers(false);
        // 文件日志处理器
        FileHandler fileHandler = new FileHandler("./log_to_file.log");
        Formatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);

        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.info("info信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");

    }


}

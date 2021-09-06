package cn.itcast.jul;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * JUL自定义配置之日志输出到文件
 * 做文件日志打印，新日志会覆盖掉原来的日志
 * 但是我们现在的需求不是覆盖，而是追加，
 */
public class CustomConfigOutputFile {
    @Test
    public void customConfigOutputFileTest() throws IOException {
        InputStream fileInputStream = new FileInputStream("./custom_file_logging.properties");
        // 取得日志管理器对象
        LogManager logManager = LogManager.getLogManager();
        // 读取自定义的配置文件
        logManager.readConfiguration(fileInputStream);
        // 日志记录器
        Logger logger = Logger.getLogger("cn.itcast.jul.CustomConfigFileTest");

        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.info("info信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");
    }
}

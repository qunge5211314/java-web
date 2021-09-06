package cn.itcast.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Log4j入门案例
 */
public class Log4jPrimerTest {
    @Test
    public void log4jPrimerTest(){
        // 加载初始化配置
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(Log4jPrimerTest.class);
        logger.info("info信息");
    }
}

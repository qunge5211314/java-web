package cn.itcast.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackPrimerTest {
    @Test
    public void logbackPrimerTest(){
        Logger logger = LoggerFactory.getLogger(LogbackPrimerTest.class);
        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
    }
}

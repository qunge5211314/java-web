package cn.itcast.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j集成Logback
 */
public class Slf4jAndLogbackTest4 {
    @Test
    public void slf4jAndLogbackTest4(){
        Logger logger = LoggerFactory.getLogger(Slf4jAndLogbackTest4.class);
        try {
            Class<?> aaa = Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            logger.error("具体错误是：", e);
        }
    }
}

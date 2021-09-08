package cn.itcast.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jAndLog4jTest5 {
    @Test
    public void slf4jAndLog4jTest5(){
        Logger logger = LoggerFactory.getLogger(Slf4jAndLog4jTest5.class);
        try {
            Class<?> aaa = Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            logger.error("具体错误是：", e);
        }
    }
}

package cn.itcast.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Slf4j入门案例
 *
 * Slf4j对日志级别的划分
 *  trace、debug、info(默认打印级别)、warn、error五个级别
 * 在没有任何其他日志实现框架集成的基础上
 * slf4j使用的就是自带的框架slf4j-simple
 * slf4j-simple也必须以单独依赖的形式导入进来
 */
public class Slf4jPrimerTest1 {
    @Test
    public void slf4jPrimerTest(){
        Logger logger = LoggerFactory.getLogger(Slf4jPrimerTest1.class);
        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
    }
}

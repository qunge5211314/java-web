package cn.itcast.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * 关于log4j.properties中layout的配置
 *  其中PatternLayout是日常使用最多的方式
 *  查看其源码setConversionPattern这个方法就是PatterLayout的核心方法
 *  String conversionPattern
 *  在log4j.properties将layout设置为PatterLayout
 *  我们主要配置的是conversionPattern属性
 */
public class ConfigFileTest03 {
    @Test
    public void configFileTest03(){
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(ConfigFileTest03.class);

        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.fatal("fatal信息");
    }
}

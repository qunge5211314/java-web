package cn.itcast.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * 通过Logger中的开关打开日志输出中的详细信息
 *
 * 查看LogManager类中的getLoggerRepository方法
 * 找到LogLog.debug(msg, ex)
 * LogLog会使用debug日志级别的输出为我们展现日志输出的详细信息
 * Logger是用来记录系统的日志，LogLog是用来记录Logger的日志
 *
 * 进入到LogLog.debug(msg, ex)方法当中
 * 通过代码if(debugEnabled && !quietMode)观察到if判断中的这两个开关都必须开启才行
 * !quietMode是已经启动的状态，不需要我们去管
 * debugEnabled默认是关闭的，所以我们只需要设置debugEnabled为true就可以了
 */
public class ConfigFileTest02 {
    @Test
    public void configFileTest02(){
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(ConfigFileTest02.class);

        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.fatal("fatal信息");
    }
}

package cn.itcast.log4j;


import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * 将日志信息输出到文件中
 * 一般情况下，我们也可以做多方向的输出，所以控制台的配置我们保留
 * 我们完全可以再来一套关于输出到文件的配置
 * 日志文件要保存到哪个路径相关的配置
 * 查看FileAppender源码
 * protected boolean fileAppend = true;表示是否追加信息
 * protected int bufferSize = 8*1024; 表示缓冲区大小
 *
 * 继续观察，找到setFile方法，这个方法就是用来指定文件位置的方法
 * 通过ognl，可以推断setFile方法操作的属性就是file
 *
 * 如果有输出中文的需求怎么办
 * 观察FileAppender的父类
 * 找到protected String encoding;属性
 *
 */
public class ConfigFileTest04 {
    @Test
    public void configFileTest04(){

        Logger logger = Logger.getLogger(ConfigFileTest04.class);

        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.fatal("fatal信息");
    }
}

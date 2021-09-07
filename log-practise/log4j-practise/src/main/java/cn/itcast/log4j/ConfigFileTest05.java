package cn.itcast.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 将日志输出到文件中
 * 但是如果日志太多了，不方便管理和维护怎么办
 * FileAppender为我们提供了好用的子类来进一步对于文件的输出进行处理
 * control+H查看FileAppender的子类RollingFileAppender和DailyRollingFileAppender
 * 先来学习RollingFileAppender
 * 这个类表示使用按照文件大小进行拆分的方式进行操作
 * 配置文件进行RollingFileAppender相关配置
 * 如何进行拆分，观察RollingFileAppender的源码
 * protected long maxFileSize = 10*1024*1024; 表示拆分文件的大小
 * protected int  maxBackupIndex  = 1;表示拆分文件的数量
 *  # 指定日志文件内容大小
 * log4j.appender.rollingFile.maxFileSize=1MB
 * # 指定日志文件的数量
 * log4j.appender.rollingFile.maxBackupIndex=5
 * 只要文件超过1MB，那么则生成另外一个文件，文件数量最多是5个
 * 如果5个文件不够怎么办，作为日志管理来讲也不可能让日志继续无休止地增长下去
 * 所以，覆盖文件的策略是按照时间来进行覆盖，原则就是保留新的覆盖旧的
 *
 */
public class ConfigFileTest05 {
    @Test
    public void configFileTest05(){
        Logger logger = Logger.getLogger(ConfigFileTest05.class);
        for (int i = 0; i < 10000; i++) {
            logger.trace("trace信息");
            logger.debug("debug信息");
            logger.info("info信息");
            logger.warn("warn信息");
            logger.error("error信息");
            logger.fatal("fatal信息");
        }
    }
}

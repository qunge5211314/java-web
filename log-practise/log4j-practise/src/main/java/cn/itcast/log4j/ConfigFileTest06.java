package cn.itcast.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 将日志输出到文件中
 * 但是如果日志太多了，不方便管理和维护怎么办
 * FileAppender为我们提供了好用的子类来进一步对于文件的输出进行处理
 * control+H查看FileAppender的子类RollingFileAppender和DailyRollingFileAppender
 * 继续学习DailyRollingFileAppender
 * 按照时间来进行文件拆分
 * 查看源码属性
 * private String datePattern = "'.'yyyy-MM-dd"; 默认是按照天来进行拆分的
 * 注意：
 *     我们在练习的时候，可以根据秒来指定拆分策略
 *     但是实际生产环境中，根据秒生成日志文件是绝对不可能的
 *     如果是大型的项目，可以根据天进行拆分
 *     或者如果是小型的项目，可以根据周、月进行拆分
 */
public class ConfigFileTest06 {
    @Test
    public void configFileTest06() {
        Logger logger = Logger.getLogger(ConfigFileTest06.class);

        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.fatal("fatal信息");

    }
}

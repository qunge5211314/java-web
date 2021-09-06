package cn.itcast.jul;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * JUL日志级别学习
 */
public class LogLevelTest {
    @Test
    public void julLogLevelTest1(){
        /*
        日志的级别
        SEVERE：错误(最高级)级别 ----------->最高级别
        WARNING：警告级别
        INGO：默认级别(消息)
        CONFIG：配置级别
        FINE：详细信息级别(少)
        FINER：详细信息级别(中)
        FINEST：详细信息级别(多) ----------->最低级别
        两个特殊的级别：
        OFF：可用来关闭日志记录
        ALL：启用所有消息的日志记录

        对于日志级别，我们重点关注的是new对象的时候的第二个参数
        是一个数值
        OFF：Integer.MAX_VALUE
        SEVERE：1000
        CONFIG：700
        ...
        FINEST：300
        ALL：Integer.MIN_VALUE
        这个数值的意义在于，如果我们设置的日志级别是INFO--->800
        那么最终展现的日志信息必须是数值大于800的所有的日志信息
         */
        Logger logger = Logger.getLogger("cn.itcast.jul.LogLevelTest");

        /*
        如果只是通过以下方式设置日志级别，那么不能够起到效果
        将来需要搭配处理器handler共同设置才会生效
         */
        logger.setLevel(Level.ALL);

        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.info("info信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");
        /*
        通过打印结果，我们看到了仅仅只是输出了INFO级别和比INFO级别高的日志信息。
        比INFO级别低的信息没有输出出来
        证明INFO级别的日志信息，它是系统默认的日志级别
        在默认INFO级别的日志信息的基础上，打印比他级别高的日志信息。
         */

    }
}

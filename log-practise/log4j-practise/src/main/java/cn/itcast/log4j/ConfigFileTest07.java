package cn.itcast.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;


/**
 * Log4j的自定义Logger
 *     我们以前所创建出来的Logger对象，默认都是继承RootLogger的
 *     我们也可以自定义Logger，让其他的Logger来继承这个Logger
 *     这种继承关系就是按照包结构的关系来进行指定的
 *     例如我们当前这个类中，
 *     Logger logger = Logger.getLogger(ConfigFileTest07.class);
 *     路径就是cn.itcast.log4j.ConfigFileTest07
 *     它的父Logger就是上层路径或者是更上层的路径
 *     参照logger是如何加载配置文件的
 *     查看PropertyConfigurator的源码
 *     得到信息log4j.logger.
 *     这个属性值就是我们在配置文件中对于自定义logger的配置属性
 *
 *     假设我们的配置是这样的
 *     log4j.rootLogger=trace,file
 *     log4j.logger.cn.itcast.log4j.ConfigFileTest07=all,console
 *
 *     观察结果
 *          控制台输出了信息
 *          日志文件也输出了信息
 *     所以可以得出结论：
 *          如果根结点的logger和自定义父logger配置的输出位置是不同的，则取二者的并集，配置的位置都会进行输出操作
 *          如果二者配置的日志级别不同主要以按照我们自定义的父Logger级别输出为主
 */
public class ConfigFileTest07 {
    @Test
    public void configFileTest07(){
        Logger logger = Logger.getLogger(ConfigFileTest07.class);
        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
        logger.fatal("fatal信息");
    }
}

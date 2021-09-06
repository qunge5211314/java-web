package cn.itcast.log4j;

/**
 * Log4j配置文件的学习
 * 01配置文件的使用
 *   1、观察源代码，BasicConfigurator.configure();可以得到两条信息：
 *      (1)创建了根结点的对象 Logger root = Logger.getRootLogger();
 *      (2)根节点添加了ConsoleAppender对象(表示默认打印到控制台，自定义的格式化输出)
 *   2、我们这一次，不使用BasicConfigurator.configure()；
 *          使用自定义的配置文件来实现功能
 *          通过我们对于以上第一点的分析
 *          我们的配置文件需要提供Logger、Appender、Layout这三个组件信息(通过配置来代替以上的代码)
 *
 *          分析Logger logger = Logger.getLogger(Log4jPrimerTest.class);
 *          进入到getLogger方法，会看到LogManager.getLogger(clazz.getName());
 *          LogManager：日志管理器
 *          点开这个LogManager看看这个日志管理器都实现了什么，看到很多常量信息，他们代表的就是不同形式(后缀名不同)的配置文件
 *          我们最常使用到的肯定是log4j.properties属性文件(语法简单、使用方便)
 *          问题：log4j.properties的加载时机
 *          继续观察LogManager，找到其中的静态代码块static，
 *          在static代码块中，我们找到Loader.getResource(DEFAULT_CONFIGURATION_FILE)
 *          这行代码给我们的最大提示信息就是系统默认要从当前的类路径下找到log4j.properties
 *          对于我们当前的项目是maven工程，那么理应在resources路径下去找
 *          加载完毕后，我们来观察配置文件是如何读取的
 *          继续观察LogManager，找到OptionConverter.selectAndConfigure(url, configuratorClassName,
 * 					   LogManager.getLoggerRepository());
 * 			作为属性文件的加载，执行configurator = new PropertyConfigurator();
 * 		    进入到PropertyConfigurator类中，观察到里面的常量信息
 * 		    这些常量信息就是我们在properties属性文件中的各种属性配置项
 * 		    其中，我们看到了如下两行信息，这两项信息是必须要进行配置的
 *          static final String ROOT_LOGGER_PREFIX   = "log4j.rootLogger";
 *          static final String      APPENDER_PREFIX = "log4j.appender.";
 *
 *          通过String prefix = APPENDER_PREFIX + appenderName; 代码：
 *          我们需要自定义一个appenderName，假设我们起名叫console
 *          (起名字也要见名知义)
 *          log4j.appender.console取值就是log4j为我们提供的Appender类
 *          例如 log4j.appender.console = org.apache.log4j.ConsoleAppender
 *
 *          在appender输出的过程中，还可以同时指定输出的格式
 *          通过代码String layoutPrefix = prefix + ".layout";
 *          配置
 *          log4j.appender.console.layout = org.apache.log4j.PatternLayout
 *
 *
 *
 *
 */
public class ConfigFileTest01 {
}

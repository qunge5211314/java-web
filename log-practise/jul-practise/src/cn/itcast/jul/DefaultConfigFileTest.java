package cn.itcast.jul;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 默认配置文件的位置
 * 之前所有的配置相关的操作都是以java硬编码的方式进行的，
 * 我们可以使用一种更加清晰更加专业的一种做法，就是使用配置文件。
 * 如果我们没有自己添加配置文件，则会使用系统默认的配置文件
 * 这个配置文件：
 *      owner.readPrimordialConfiguration();
 *      readConfiguration();
 *      java.home ---> 找到jre文件夹 ---> lib ---> logging.properties
 */
public class DefaultConfigFileTest {
    @Test
    public void defaultConfigFileTest(){
        // 日志记录器
        Logger logger = Logger.getLogger("cn.itcast.jul.DefaultConfigFileTest");
    }
}

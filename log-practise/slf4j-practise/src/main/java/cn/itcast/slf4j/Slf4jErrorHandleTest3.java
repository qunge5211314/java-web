package cn.itcast.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jErrorHandleTest3 {
    @Test
    public void slf4jErrorHandleTest3() {
        Logger logger = LoggerFactory.getLogger(Slf4jErrorHandleTest3.class);
        try {
            Class<?> aaa = Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            // 打印栈追踪信息
            //           e.printStackTrace();
            logger.error("XXX类中的XXX方法出现了异常，请及时处理");
            // e是引用类型对象，不能跟前面的花括号做有效的字符串拼接
            // 这时我们不用加花括号，直接加上异常对象即可
            //logger.error("具体错误是：{}", e);
            logger.error("具体错误是：", e);
        }
    }
}

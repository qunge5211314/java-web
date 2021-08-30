package cn.itcast.test;

import cn.itcast.junit.Caculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaculatorTest {

    /**
     * 初始化方法：
     *   用于资源申请，所有测试方法在执行之前都会执行该方法
     */
    @Before
    public void init(){
        System.out.println("init......");
    }

    /**
     * 释放资源方法：
     *  在所有测试方法执行完毕后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close......");
    }

    /**
     * 测试sum方法
     */
    @Test
    public void testSun() {
        // 1.创建Caculator对象
        Caculator caculator = new Caculator();
        // 2.调用sum方法
        int result = caculator.sum(1, 2);
        // System.out.println(result);
        // 3.断言 断言这个结果为3
        Assert.assertEquals(3, result);
    }
}

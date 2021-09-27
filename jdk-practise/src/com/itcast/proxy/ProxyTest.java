package com.itcast.proxy;


import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    // 1、创建真实对象
    private LenovoComputer lenovoComputer;

    @Before
    public void before() {
        lenovoComputer = new LenovoComputer();
    }

    /**
     * 常规情况下，未做方法增强
     */
    @Test
    public void proxyTest01() {
        // 2、调用方法
        lenovoComputer.show();
        lenovoComputer.sale(8000D);
    }

    /**
     * 使用动态代理
     */
    @Test
    public void proxyTest02() {
        // 2、创建代理对象，动态代理增强lenovoComputer对象及其方法
        /*
            三个参数：
                1、类加载器：真实对象.getClass().getClassLoader()
                2、接口数组：真实对象.getClass().getInterfaces()
                3、处理器：new InvocationHandler()
         */
        Computer proxyLenovoComputer = (Computer) Proxy.newProxyInstance(lenovoComputer.getClass().getClassLoader(),
                lenovoComputer.getClass().getInterfaces(), new InvocationHandler() {
                    /*
                    代理逻辑编写的方法，代理对象调用的所有方法都会触发该方法执行
                        参数：
                            1、proxy：代理对象
                            2、method：代理对象调用的方法，被封装为的对象
                            3、args：代理对象调用的方法时，传递的实际参数
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName() + "方法：");
                        System.out.println("该方法执行了。。。。。");
                        if (args != null) {
                            for (Object arg : args) {
                                System.out.println(arg);
                            }
                        }
                        return null;
                    }
                });
        // 3、调用方法
        proxyLenovoComputer.show();
        String computer = proxyLenovoComputer.sale(8000D);
        System.out.println(computer);
    }

    /**
     * 增强实现
     */
    @Test
    public void proxyTest03() {
        // 2、创建代理对象，动态代理增强lenovoComputer对象及其方法
        Computer proxyLenovoComputer = (Computer) Proxy.newProxyInstance(lenovoComputer.getClass().getClassLoader(),
                lenovoComputer.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName() + "方法：");
                        System.out.println("该方法执行了。。。。。");
                        // 使用真实对象调用该方法
                        Object result = method.invoke(lenovoComputer, args);
                        System.out.println("------------------------------");
                        return result;
                    }
                });
        // 3、调用方法
        proxyLenovoComputer.show();
        String computer = proxyLenovoComputer.sale(8000D);
        System.out.println(computer);
    }

    /**
     * 增强方式
     */
    @Test
    public void proxyTest04() {
        // 2、创建代理对象，动态代理增强lenovoComputer对象及其方法
        Computer proxyLenovoComputer = (Computer) Proxy.newProxyInstance(lenovoComputer.getClass().getClassLoader(),
                lenovoComputer.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName() + "方法：");
                        if (method.getName().equals("sale")) {
                            // 1、增强参数
                            Double money = (Double) args[0];
                            money = money * 0.85;
                            // 3、增强业务逻辑
                            System.out.println("专车接你");
                            // 2、增强返回值
                            String result = (String) method.invoke(lenovoComputer, money);
                            System.out.println("专车送你");
                            System.out.println("------------------------------");
                            return result + "+赠送一个贴膜+赠送一个鼠标垫";
                        } else {
                            Object result = method.invoke(lenovoComputer, args);
                            System.out.println("------------------------------");
                            return result;
                        }

                    }
                });
        // 3、调用方法
        proxyLenovoComputer.show();
        String computer = proxyLenovoComputer.sale(8000D);
        System.out.println(computer);
    }
}

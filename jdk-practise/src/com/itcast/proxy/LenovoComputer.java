package com.itcast.proxy;

/**
 * 真实类
 */
public class LenovoComputer implements Computer{
    @Override
    public void show() {
        System.out.println("联想电脑显示功能");
    }

    @Override
    public String sale(Double money) {
        System.out.println("用户花了"+money+"元钱，买了一台联想电脑");
        return "联想电脑";
    }
}

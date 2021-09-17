package com.itcast.box;

/**
 * 装箱：把基本数据类型转换为对应的包装类型
 * 拆箱：把包装类型转换为对应的基本数据类型
 */
public class BoxPractise {
    public static void main(String[] args) {
        // 装箱：把基本数据类型转换为对应的包装类型
        Integer i = Integer.valueOf(100);
        // 自动装箱
        Integer ii = 100; // 底层也做了Integer.valueOf(100); jdk5以后简化了


        // 拆箱：把包装类型转换为对应的基本数据类型
        // ii += 200;
        // ii.intValue()为手动拆箱
        // ii.intValue() + 200拆箱后求和
        // ii = ii.intValue() + 200; 将求和结果再自动装箱赋值给ii。
        ii = ii.intValue() + 200;
        // 以下是自动拆箱装箱
        ii += 200;
        System.out.println(ii);

        Integer iii = null;
        if (iii != null) {
            iii += 300;  // NullPointerException
        }
    }
}

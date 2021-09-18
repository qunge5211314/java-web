package com.itcast.lambda;

/**
 * Lambda表达式练习一：有参无返回值
 */
public class FlyableDemo {
    public static void main(String[] args) {
        useFlyable((String s) -> {
            System.out.println(s);
            System.out.println("飞机在天上飞");
        });
    }

    private static void useFlyable(Flyable f) {
        f.fly("风和日丽，晴空万里");
    }
}

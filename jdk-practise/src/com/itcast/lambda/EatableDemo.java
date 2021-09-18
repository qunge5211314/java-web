package com.itcast.lambda;

/**
 * Lambda表达式练习一：无参无返回值
 */
public class EatableDemo {
    public static void main(String[] args) {
        useEatable(() -> {
            System.out.println("吃饭");
        });
    }

    private static void useEatable(Eatable e) {
        e.eat();
    }
}

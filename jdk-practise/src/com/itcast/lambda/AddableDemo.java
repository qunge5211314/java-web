package com.itcast.lambda;

/**
 * Lambda表达式练习三：有参有返回值
 */
public class AddableDemo {
    public static void main(String[] args) {

        useAddable((int x, int y) -> {
            return x + y;
        });

    }

    private static void useAddable(Addable a) {
        int sum = a.add(3, 4);
        System.out.println(sum);
    }
}

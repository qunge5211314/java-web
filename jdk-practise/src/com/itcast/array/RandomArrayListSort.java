package com.itcast.array;

import java.util.Arrays;
import java.util.Random;

public class RandomArrayListSort {
    public static void main(String[] args) {
        Integer[] integers = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integers[i] = random.nextInt(10) + 1;
        }
        System.out.println("before sort：");
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        Arrays.sort(integers);
        System.out.println("after sort:");
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}

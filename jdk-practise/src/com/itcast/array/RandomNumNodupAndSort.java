package com.itcast.array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;

public class RandomNumNodupAndSort {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedHashSet<Integer> integers = new LinkedHashSet<>();
        while (true) {
            integers.add(random.nextInt(100));
            if (integers.size() == 10) {
                break;
            }
        }
        Object[] objects = integers.toArray();
        Arrays.sort(objects);
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}

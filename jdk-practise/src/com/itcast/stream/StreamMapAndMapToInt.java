package com.itcast.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class StreamMapAndMapToInt {
    public static void main(String[] args) {
        // 创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");
        list.add("60");

        //需求：将集合中的字符串数据转换为整数之后在控制台输出
        list.stream().map(s -> Integer.parseInt(s) + 50).forEach(System.out::println);
        System.out.println("-----------------------------------");
        list.stream().mapToInt(Integer::parseInt).forEach(System.out::println);
        System.out.println("-----------------------------------");
        // IntStream().sum()返回此流中元素的总和
        int sum = list.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
        System.out.println("-----------------------------------");
        // IntStream().max()返回此流中元素的最大值 IntStream().min()返回此流中元素的最小值
        OptionalInt min = list.stream().mapToInt(Integer::parseInt).min();
        System.out.println(min.getAsInt());
    }
}

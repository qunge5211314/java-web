package com.itcast.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream<T> filter(Predicate predicate)：用于对流中数据进行过滤
 * Predicate接口中的方法：boolean test(T t)：对给定的参数进行判断，返回一个布尔值
 */
public class StreamFilter {
    public static void main(String[] args) {
        // 1、创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        // 需求1：把list集合中以张字开头的元素在控制台输出
        list.stream().
                filter(s -> s.startsWith("张")).
                forEach(System.out::println);
        System.out.println("-----------------------------------------");
        // 需求2：把list集合中长度为3的元素在控制台输出
        list.stream().
                filter(s -> s.length() == 3).
                forEach(System.out::println);
        System.out.println("-----------------------------------------");
        // 需求3：把list集合中以张字开头的，长度为3的元素在控制台输出
        list.stream().
                filter(s -> s.startsWith("张")).
                filter(s -> s.length() == 3).
                forEach(System.out::println);
    }
}

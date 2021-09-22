package com.itcast.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamSort {
    public static void main(String[] args) {
        // 1、创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("linqingxia");
        list.add("zhangmanyu");
        list.add("wangzuxian");
        list.add("liuyan");
        list.add("zhangmin");
        list.add("zhangwuji");

        // 需求1：按照字母顺序把数据在控制台输出
        list.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------------");
        // 需求2：按照字符串长度把数据在控制台输出
        list.stream().sorted((s1, s2) -> s1.length() - s2.length()).forEach(System.out::println);
        System.out.println("----------------------------");
        // 以上是单纯按字符串长度排序，如果字符串长度相同，那么使用自然排序的方式则如下实现：
        list.stream().sorted((s1, s2) -> {
            return s1.length() - s2.length() != 0 ? s1.length() - s2.length() : s1.compareTo(s2);
        }).forEach(System.out::println);
    }
}

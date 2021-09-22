package com.itcast.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamForEachAndCount {
    public static void main(String[] args) {
        // 创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        // 需求1：把集合中的元素在控制台输出
        list.stream().forEach(System.out::println);
        System.out.println("----------------------------");
        // 需求2：统计集合中有几个以"张"开头的元素，并把统计结果在控制台输出
        long count = list.stream().filter(s -> s.startsWith("张")).count();
        System.out.println(count);
    }
}

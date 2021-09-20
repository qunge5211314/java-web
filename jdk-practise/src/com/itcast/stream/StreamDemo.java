package com.itcast.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 体验stream流
 * 需求：
 * 1、创建一个集合，存储多个字符串元素
 * 2、把集合中所有以"张"开头的元素存储到一个新的集合
 * 3、把"张"开头的集合中的长度为3的元素存储到一个新的集合
 * 4、遍历上一步得到的集合
 */
public class StreamDemo {
    public static void main(String[] args) {
        // 1、创建一个集合，存储多个字符串元素
        List<String> stringList = new ArrayList<>();
        stringList.add("林青霞");
        stringList.add("张曼玉");
        stringList.add("王祖贤");
        stringList.add("柳岩");
        stringList.add("张敏");
        stringList.add("张无忌");

        // stream流实现
        stringList.stream().
                filter(string -> string.startsWith("张")).
                filter(string -> string.length() == 3).forEach(System.out::println);
    }
}

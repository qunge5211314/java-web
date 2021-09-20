package com.itcast.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamConcatDistinct {
    public static void main(String[] args) {
        // 创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        // 1、需求1：取前四个数据组成一个流
        Stream<String> limitStream = list.stream().limit(4);
        // 2、需求2：跳过两个数据组成一个流
        Stream<String> skipStream = list.stream().skip(2);
        // 3、需求3：合并需求1和需求2得到的流，并把结果在控制台输出
//        Stream.concat(limitStream, skipStream).forEach(System.out::println);
        System.out.println("--------------------");
        // 4、需求4：合并需求1和需求2得到的流，并把结果在控制台输出，要求字符串元素不能重复
        Stream.concat(limitStream, skipStream).distinct().forEach(System.out::println);
    }
}

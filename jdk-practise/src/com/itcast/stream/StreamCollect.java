package com.itcast.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {
    public static void main(String[] args) {
        // 创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        // 需求1：得到名字为3个字的流
        Stream<String> stringStream = list.stream().filter(s -> s.length() == 3);
        // 需求2：把使用Stream流操作完毕的数据收集到List集合中并遍历
        List<String> stringList = stringStream.collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }
        System.out.println("--------------------------");
        // 创建set集合对象
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(33);
        set.add(35);

        // 需求3：得到年龄大于25的流
        Stream<Integer> integerStream = set.stream().filter(i -> i > 25);
        // 需求4：把使用Stream流操作完毕的数据收集到Set集合中并遍历
        Set<Integer> integerSet = integerStream.collect(Collectors.toSet());
        for (Integer integer : integerSet) {
            System.out.println(integer);
        }

        System.out.println("-----------------------------");
        // 定义一个字符串数组，每一个字符串数据由姓名数据和年龄数据组合而成
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33", "柳岩,25"};
        // 需求5：得到字符串中年龄大于28的流
        Stream<String> over28Stream = Arrays.stream(strArray).filter(s ->
                Integer.parseInt(s.split(",")[1]) > 28);
//        Stream<String> over28Stream = Stream.of(strArray).filter(s ->
//                Integer.parseInt(s.split(",")[1]) > 28);

        // 需求6：把使用stream流操作完毕的数据收集到Map集合中并遍历，字符串中的姓名做键，年龄做值
        Map<String, String> map = over28Stream.collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry);
        }

    }
}

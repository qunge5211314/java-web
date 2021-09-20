package com.itcast.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream流常见生成方式
 */
public class StreamGenerateWay {
    public static void main(String[] args) {
        // 1、Collection体系的集合可以使用默认方法stream()生成流
        //            default Stream<E> stream()
        List<String> list = new ArrayList<>();
        Stream<String> listStream = list.stream();

        HashSet<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        // 2、Map体系的集合间接地生成流
        Map<String, Integer> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        // 3、数组可以通过Stream接口的静态方法of(T...values)生成流
        String[] stringArray = {"hello", "world", "java"};
        Stream<String> stringArrayStream = Stream.of(stringArray);
        Stream<String> stringStream = Stream.of("hello", "world", "java");
    }
}

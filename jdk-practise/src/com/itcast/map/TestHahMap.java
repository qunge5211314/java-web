package com.itcast.map;

import java.util.HashMap;
import java.util.Map;

public class TestHahMap {
    public static void main(String[] args) {
        Map<Integer, String> map=new HashMap<>();
        map.put(1, "asd");
        System.out.println(map);
        String s = map.get(2);
        System.out.println(s);
    }
}

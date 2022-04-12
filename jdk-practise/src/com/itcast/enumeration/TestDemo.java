package com.itcast.enumeration;

import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        Map<Long, TestEnum> testEnum = TestEnum.toMap();
        for (Long aLong : testEnum.keySet()) {
            System.out.println(aLong+":"+testEnum.get(aLong).getValue());
        }
    }
}

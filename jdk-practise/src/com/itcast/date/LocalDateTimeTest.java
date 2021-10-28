package com.itcast.date;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        // 获取当前时间
        System.out.println(LocalDateTime.now());
        // 获取本日0点
        System.out.println(LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIN));
        // 获取本日23:59:59.9999
        System.out.println(LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MAX));
        // 获取本月1日0点
        System.out.println(LocalDateTime.of(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).toLocalDate(), LocalTime.MIN));
        // 获取本月最后一日23:59:59.9999
        System.out.println(LocalDateTime.of(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).toLocalDate(), LocalTime.MAX));


    }
}

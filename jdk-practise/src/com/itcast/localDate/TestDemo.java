package com.itcast.localDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        String start = "20210421";
        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long gznx = ChronoUnit.YEARS.between(startDate, now);
        System.out.println(gznx);
    }
}

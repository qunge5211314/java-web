package com.itcast.date;


import java.util.Calendar;
import java.util.Date;

/**
 * Calendar为某一时刻和一组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法
 * Calendar提供了一个类方法getInstance用于获取Calendar对象，其日历字段已使用当前日期和时间初始化；
 * Calendar rightNow = Calendar.getInstance()
 */
public class CalendarPractise {
    public static void main(String[] args) {
        // 获取对象
        Calendar rightNow = Calendar.getInstance(); // 多态的形式
        System.out.println(rightNow);

        // public int get(int field)
        int year = rightNow.get(Calendar.YEAR);
        System.out.println(year);
        int month = rightNow.get(Calendar.MONTH) + 1; //注意月是从0开始的
        System.out.println(month);

        rightNow.add(Calendar.MONTH, 4);
        int i = rightNow.get(Calendar.MONTH);
        System.out.println(i);
        // Date与Calendar互相转换
        Date time = rightNow.getTime();
        Date date = new Date();
        rightNow.setTime(date);
    }
}

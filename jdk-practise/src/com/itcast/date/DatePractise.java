package com.itcast.date;


import java.util.Date;

/**
 * Date() 分配一个 Date对象并将它初始化，它代表的时间分配给它，测量精确到毫秒。
 * Date(long date) 分配一个 Date对象并将它初始化为代表指定的毫秒数自基准时间被称为“时间戳”，即1970年1月1日，00:00:00 GMT。
 */
public class DatePractise {
    public static void main(String[] args) {

        // Date() 分配一个 Date对象并将它初始化，它代表的时间分配给它，测量精确到毫秒。
        Date date1 = new Date();
        System.out.println(date1);
        // Date(long date) 分配一个 Date对象并将它初始化为代表指定的毫秒数自基准时间被称为“时间戳”，即1970年1月1日，00:00:00 GMT。
        long millisecond = 1000 * 60 * 60;
        Date date2 = new Date(millisecond);
        System.out.println(date2);

        //long getTime() 获取的是日期对象从1970年1月1日00:00:00到现在的毫秒值
        System.out.println(date1.getTime());

        //void setTime(long time) 设置时间，给的是毫秒值
        date2.setTime(1000 * 60 * 60 * 2);
        System.out.println(date2);
    }
}

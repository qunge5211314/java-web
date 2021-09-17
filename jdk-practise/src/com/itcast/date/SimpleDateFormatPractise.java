package com.itcast.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 构造方法：
 *    public SimpleDateFormat()构造一个SimpleDateFormat，使用默认模式和日期格式
 *    public SimpleDateFormat(String pattern)构造一个SimpleDateFormat，使用给定的模式和默认的日期格式
 * 格式化：
 *    从Date到String：
 *      public final String format(Date date)： 将日期格式化成日期/时间字符串
 * 解析：
 *    从String到Date：
 *      public Date parse(String source)： 从给定字符串的开始解析文本以生成日期
 */
public class SimpleDateFormatPractise {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat();
        String dateFormat1 = simpleDateFormat1.format(date);
        System.out.println(dateFormat1);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat2 = simpleDateFormat2.format(date);
        System.out.println(dateFormat2);
        System.out.println("-------------------");
        String dateString = "2021-09-17 15:00:00";
        Date dateParseResult = simpleDateFormat2.parse(dateString);
        System.out.println(dateParseResult);

    }
}

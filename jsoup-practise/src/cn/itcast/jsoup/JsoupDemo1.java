package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup快速入门
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        // 1.获取Decument对象,根据一个xml文档来获取
        // 1.1获取student.xml文件的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 1.2解析xml文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 2.获取元素对象
        Elements allElements = document.getAllElements();
        for (Element element : allElements) {
            System.out.println(element);
        }
    }
}

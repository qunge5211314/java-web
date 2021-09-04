package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 */
public class SelectorPractise {
    public static void main(String[] args) throws IOException {
        // 1.获取Decument对象,根据一个xml文档来获取
        // 1.1获取student.xml文件的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 1.2解析xml文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 2.查询name标签
        Elements nameElements = document.select("name");
        for (Element nameElement : nameElements) {
            System.out.println(nameElement);
        }
        System.out.println("----------------------");
        // 3.查询id值为zhangsan的元素
        Elements idElements = document.select("#zhangsan");
        for (Element idElement : idElements) {
            System.out.println(idElement);
        }
        System.out.println("----------------------");
        // 4.获取student标签并且number属性值为s001的age子标签
        // 4.1获取student标签并且number属性值为s001
        Elements studentElements1 = document.select("student[number='s001']");
        System.out.println(studentElements1);
        System.out.println("----------------------");
        // 4.2获取student标签并且number属性值为s001的age子标签
        Elements studentElements2 = document.select("student[number='s001'] > age");
        System.out.println(studentElements2);

    }
}

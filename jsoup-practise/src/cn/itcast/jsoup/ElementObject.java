package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象
 */
public class ElementObject {
    public static void main(String[] args) throws IOException {
        // 1.获取Decument对象,根据一个xml文档来获取
        // 1.1获取student.xml文件的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 1.2解析xml文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 2.获取student元素对象集合
        Elements studentElements = document.getElementsByTag("student");
        // 3.获取第一个student元素对象
        Element student0 = studentElements.get(0);
        // 4.通过student元素对象获取子标签名为name的元素集合
        Elements nameElements = student0.getElementsByTag("name");
        for (Element nameElement : nameElements) {
            System.out.println(nameElement);
        }
        System.out.println("--------------------");
        // 5.获取第一个name元素对象
        Element nameElement = nameElements.get(0);
        // 6.获取name元素对象中id属性的值
        String id = nameElement.attr("id");
        System.out.println("id:" + id);
        System.out.println("--------------------");
        // 7.获取文本内容
        String text = nameElement.text();
        System.out.println("text:" + text);
        String html = nameElement.html();
        System.out.println("html:" + html);
    }
}

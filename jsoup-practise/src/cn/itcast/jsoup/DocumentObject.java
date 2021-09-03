package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document对象中的常用方法
 */
public class DocumentObject {
    public static void main(String[] args) throws IOException {
        // 1.获取Decument对象,根据一个xml文档来获取
        // 1.1获取student.xml文件的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 1.2解析xml文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 2.获取student元素对象
        Elements studentElements = document.getElementsByTag("student");
        for (Element studentElement : studentElements) {
            System.out.println(studentElement);
        }
        System.out.println("----------------------------");
        // 3.获取属性名为id的所有元素
        Elements idElements = document.getElementsByAttribute("number");
        for (Element idElement : idElements) {
            System.out.println(idElement);
        }
        System.out.println("----------------------------");
        // 4.获取number属性值为s001的元素
        Elements elementsByAttributeValue = document.getElementsByAttributeValue("number", "s001");
        for (Element element : elementsByAttributeValue) {
            System.out.println(element);
        }
        System.out.println("----------------------------");
        // 5.获取id属性值的对象
        Element lisi = document.getElementById("lisi");
        System.out.println(lisi);
    }
}

package cn.itcast.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup工具类及其三种解析方法
 */
public class JsoupUtilClass {
    public static void main(String[] args) throws IOException {
        // 1.本地获取xml或html文件并解析
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 1.1解析xml文档
        Document document1 = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document1);
        System.out.println("---------------------");
        // 2.根据网络url获取
        URL url = new URL("https://www.baidu.com");
        Document document2 = Jsoup.parse(url, 1000);
        System.out.println(document2);
        System.out.println("---------------------");
        // 3.根据代码里的字符串解析
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<students>\n" +
                "    <student number=\"s001\">\n" +
                "        <name>zhangsan</name>\n" +
                "        <age>23</age>\n" +
                "        <sex>male</sex>\n" +
                "    </student>\n" +
                "    <student number=\"s002\">\n" +
                "        <name>lisi</name>\n" +
                "        <age>24</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "</students>";
        Document document3 = Jsoup.parse(xmlString);
        System.out.println(document3);
    }
}

package cn.itcast.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Xpath查询
 */
public class XPathPractise {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        // 1.获取Decument对象,根据一个xml文档来获取
        // 1.1获取student.xml文件的路径
        String path = XPathPractise.class.getClassLoader().getResource("student.xml").getPath();
        // 1.2解析xml文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 2.根据Document对象创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        // 3.结合XPath的语法查询
        // 3.1查询所有的student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------");
        // 3.2查询所有student标签下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------");
        // 3.3查询student标签下带有id属性的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("------------------------");
        // 3.4查询student标签下带有id属性的name标签并且id属性值为zhangsan
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='zhangsan']");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
    }
}

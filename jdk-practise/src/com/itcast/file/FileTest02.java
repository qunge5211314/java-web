package com.itcast.file;

import java.io.File;
import java.io.IOException;

/**
 * File类创建功能
 */
public class FileTest02 {
    public static void main(String[] args) throws IOException {
        // 需求1：在~/Desktop/目录下创建一个文件java.txt
        File f1 = new File("/Users/mac/Desktop/java.txt");
        boolean newFile = f1.createNewFile();
        // 第一回true 第二回false
        System.out.println(newFile);
        // 需求2：在~/Desktop/目录下创建一个目录javaSE
        File f2 = new File("/Users/mac/Desktop/javaSE");
        boolean mkdir = f2.mkdir();
        System.out.println(mkdir);
        // 需求3：在~/Desktop/目录下创建一个多级目录javaWEB/HTML
        File f3 = new File("/Users/mac/Desktop/javaWEB/HTML");
        boolean mkdirs = f3.mkdirs();
        System.out.println(mkdirs);
        // 需求4：在~/Desktop/目录下创建一个文件javase.txt
        File f4 = new File("/Users/mac/Desktop/javase.txt");
//        System.out.println(f4.mkdir()); 此处注意调用方法不同，生成的东西不同
        System.out.println(f4.createNewFile());
    }
}

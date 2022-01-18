package com.itcast.file;

import java.io.File;

/**
 * File类删除功能
 * 注意如果一个目录中有内容(目录，文件)，不能直接删除。应该先删除目录中的内容，最后才能删除目录
 */
public class FileTest03 {
    public static void main(String[] args) {
        // 需求1：删除~/Desktop/目录下的文件java.txt
        File f1 = new File("/Users/mac/Desktop/java.txt");
        System.out.println(f1.delete());
        // 需求2：删除~/Desktop/目录下的目录javaSE
        File f2 = new File("/Users/mac/Desktop/javaSE");
        System.out.println(f2.delete());
        // 需求3：删除~/Desktop/目录下的目录javaWEB
        File f3 = new File("/Users/mac/Desktop/javaWEB");
        System.out.println(f3.delete());
    }
}

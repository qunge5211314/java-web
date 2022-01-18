package com.itcast.file;


import java.io.File;

public class FileTest01 {
    public static void main(String[] args) {
        File f1 = new File("~/Desktop/java.txt");
        System.out.println(f1);
        File f2 = new File("~/Desktop/", "java.txt");
        System.out.println(f2);
        File f3 = new File("~/Desktop/");
        File f4 = new File(f3, "java.txt");
        System.out.println(f4);

    }
}

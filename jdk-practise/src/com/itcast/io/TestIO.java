package com.itcast.io;

import java.io.File;
import java.io.FileInputStream;

public class TestIO {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/justinhan/Desktop/离职申请.doc";
        try (FileInputStream inputStream = new FileInputStream(new File(filePath))) {
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, length));
            }
        }
    }
}

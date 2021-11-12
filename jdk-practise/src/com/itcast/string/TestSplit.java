package com.itcast.string;

import java.awt.*;

public class TestSplit {
    public static void main(String[] args) {
        String a = "/0_101/0_102/0_119/0_164/0_282/1_1783";
        String[] as = a.split("/");
        for (String s : as) {
            System.out.println("result:"+s);
        }

    }
}

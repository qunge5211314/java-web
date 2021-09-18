package com.itcast.lambda;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("多线程程序启动了-----1");
        }
    }
}

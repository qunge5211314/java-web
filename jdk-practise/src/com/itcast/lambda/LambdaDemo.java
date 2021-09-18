package com.itcast.lambda;

/**
 * 需求：启动一个线程，在控制台输出一句话：多线程程序启动了
 */
public class LambdaDemo {
    public static void main(String[] args) throws InterruptedException {

        // 实现类的方式实现需求
        Thread thread = new Thread(new MyRunnable());
        thread.start();


        // 匿名内部类的方式改进
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("多线程程序启动了-----2");
                }
            }
        }).start();

        // lambda表达式的方式改进
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println("多线程程序启动了-----3");
            }
        }).start();

    }
}

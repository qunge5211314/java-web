package com.itcast.singleton;

/**
 * 饿汉模式下的单例模式
 */
public class SingletonClass {
    private final static SingletonClass instance = new SingletonClass();

    SingletonClass() {

    }

    public static SingletonClass getInstance() {
        return instance;
    }
}

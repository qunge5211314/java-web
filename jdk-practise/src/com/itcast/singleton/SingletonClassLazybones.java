package com.itcast.singleton;

import java.util.Objects;

/**
 * 懒汉模式创建单例
 */
public class SingletonClassLazybones {
    private static SingletonClassLazybones instance;
    SingletonClassLazybones(){}
    public static synchronized SingletonClassLazybones getInstance(){
        if (Objects.isNull(instance)) {
            instance = new SingletonClassLazybones();
            return instance;
        }
        return instance;
    }
}

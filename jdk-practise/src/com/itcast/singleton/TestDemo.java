package com.itcast.singleton;

public class TestDemo {
    public static void main(String[] args) {
        SingletonClass incetance1 = SingletonClass.getInstance();
        SingletonClass incetance2 = SingletonClass.getInstance();
        System.out.println(incetance1);
        System.out.println(incetance2);
        System.out.println(incetance1==incetance2);

        SingletonClassLazybones incetance3 = SingletonClassLazybones.getInstance();
        SingletonClassLazybones incetance4 = SingletonClassLazybones.getInstance();
        System.out.println(incetance3);
        System.out.println(incetance4);
        System.out.println(incetance3==incetance4);

    }
}

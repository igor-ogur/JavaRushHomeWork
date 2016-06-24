package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by SKLAD-PC on 11.02.15.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}

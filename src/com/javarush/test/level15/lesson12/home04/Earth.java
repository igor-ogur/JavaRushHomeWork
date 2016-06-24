package com.javarush.test.level15.lesson12.home04;

/**
 * Created by SKLAD-PC on 16.02.15.
 */
public class Earth implements Planet {

    private Earth(){}

    /*private static class SingletonHelper {
        private static final Earth instance = new Earth();
    }

    public static Earth getInstance(){
        return SingletonHelper.instance;
    }*/

    private static Earth instance;

    public static Earth getInstance(){
        if (instance == null) instance = new Earth();
        return instance;
    }
}

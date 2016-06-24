package com.javarush.test.level15.lesson12.home04;

/**
 * Created by SKLAD-PC on 16.02.15.
 */
public class Moon implements Planet {

    private Moon(){}

    /*private static class SingletonHelper {
        private static final Moon instance = new Moon();
    }

    public static Moon getInstance(){
        return SingletonHelper.instance;
    }*/

    private static Moon instance;

    public static Moon getInstance(){
        if (instance == null) instance = new Moon();
        return instance;
    }
}

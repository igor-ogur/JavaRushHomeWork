package com.javarush.test.level15.lesson12.home04;

/**
 * Created by SKLAD-PC on 16.02.15.
 */
public class Sun implements Planet {

    private Sun(){}

    /*private static class SingletonHelper {
        private static final Sun instance = new Sun();
    }

    public static Sun getInstance(){
        return SingletonHelper.instance;
    }*/

    private static Sun instance;

    public static Sun getInstance(){
        if (instance == null) instance = new Sun();
        return instance;
    }
}

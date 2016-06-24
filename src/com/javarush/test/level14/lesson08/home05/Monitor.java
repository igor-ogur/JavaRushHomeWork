package com.javarush.test.level14.lesson08.home05;

/**
 * Created by SKLAD-PC on 10.02.15.
 */
public class Monitor implements CompItem {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}

package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String result = "";
        try{
            int i = string.indexOf("\t");
            int j = string.indexOf("\t", i+1);
            result = string.substring(i+1, j);
        }catch (Exception e){
            throw new TooShortStringException();
        }
        return result;
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\t\t"));
    }

    public static class TooShortStringException extends Exception {
    }
}

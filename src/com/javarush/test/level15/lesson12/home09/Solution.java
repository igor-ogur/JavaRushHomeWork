package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        //add your code here
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> objList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URI = reader.readLine();
        String s = URI.substring(URI.indexOf("?")+1);
        String[] all = s.split("&");
        for (String x : all){
            String[] parts = x.split("=");
            list.add(parts[0]);
            if (parts[0].equals("obj")) objList.add(parts[1]);
        }
        /*char[] c = s.toCharArray();
        int a = s.indexOf('?');
        s = "";

        for (int i = a+1; i < c.length; i++) {
            if (c[i] == '&'){
                beforeAlertString(s);
                s="";
                i++;
            }
            s += c[i];

        }
        beforeAlertString(s);*/
        for (String x : list){
            System.out.print(x+" ");
        }
        System.out.println();
        for (String x : objList){
            try {
                alert(Double.parseDouble(x));
            }catch (Exception e){
                alert(x);
            }
        }
    }

    /*public static void beforeAlertString(String s){
        if (!s.contains("=")) list.add(s);
        else {
            int b = s.indexOf('=');
            list.add(s.substring(0,b));
            if ((s.substring(0,b)).equals("obj")) objList.add(s.substring(b + 1));
        }
    }*/


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

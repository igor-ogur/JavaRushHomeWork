package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);
        /*ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        Collections.sort(list);*/

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //Напишите тут ваш код
        for (int j = 0; j < array.length-1; j++) {
            for (int i = 1; i < array.length; i++) {

                if (isGreaterThen(array[i - 1], array[i])) {
                    String t = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = t;
                }

            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}

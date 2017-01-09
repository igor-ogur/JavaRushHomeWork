package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "cp1251"));
        String s;
        int count = 0;
        while ((s = reader.readLine()) != null){
            String[] str = s.replaceAll("\\p{P}", " ").split(" ");
            for (String x : str){
                if (x.equals("world")) count++;
            }
        }
        System.out.println(count);
        reader.close();
    }
}

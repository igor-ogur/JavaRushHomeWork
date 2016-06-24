package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int count = 0;
        int number = 0;
        while (fis.available() > 0){
            int k = fis.read();
            int j = 0;
            FileInputStream fis2 = new FileInputStream(fileName);
            while (fis2.available() > 0){
                int i = fis2.read();
                if (k == i) j++;
            }

            if (j > count) {
                count = j;
                number = k;
            }

        }
        System.out.println(number);
        fis.close();
        reader.close();
    }
}

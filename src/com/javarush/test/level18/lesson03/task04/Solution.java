package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int[] a = new int[256];
        while (fis.available() > 0) {
            int i = fis.read();
            a[i]++;
        }
        int min = a[0];
        for (int i = 0; i < 256; i++) {
            if (a[i] < min) min = a[i];
        }
        for (int i = 0; i < 256; i++) {
            if (min == a[i]) System.out.print(i+" ");
        }
    }
}

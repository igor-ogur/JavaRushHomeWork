package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int[] a  = new int[256];
        while (fis.available() > 0) {
            int i = fis.read();
            a[i]++;
        }
        for (int i = 0; i < 256; i++) {
            if (a[i] != 0) System.out.print(i+" ");
        }

        reader.close();
        fis.close();
    }
}

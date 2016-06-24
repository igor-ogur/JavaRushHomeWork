package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(s2)));
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(s1)));
        while ((s1 = reader.readLine()) != null) {
            String[] s = s1.split(" ");
            for (int i = 0; i < s.length; i++) {
                BigDecimal bd = new BigDecimal(s[i]);
                if (bd.intValue() >= 0) bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
                else bd = bd.setScale(0, BigDecimal.ROUND_HALF_DOWN);
                writer.write(bd.toString() + " ");
            }
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}

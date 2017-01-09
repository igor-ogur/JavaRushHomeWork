package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int space = Integer.valueOf(' ');
        int p1 = 0;
        int p2 = 0;
        while (fis.available() > 0){
            if (fis.read() == space) p2++;
            p1++;
        }
        double d = (double) p2/p1*100;
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(bd.doubleValue());

        //System.out.printf("%.2f", d);
    }
}

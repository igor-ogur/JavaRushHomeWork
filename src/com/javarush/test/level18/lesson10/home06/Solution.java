package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] b = new byte[fis.available()];
        fis.read(b);
        int max = b[0];
        for (int i = 0; i < b.length; i++) {
            if (b[i] > max) max = b[i];
        }
        int[] a = new int[max+1];
        for (int i = 0; i < b.length; i++) {
            a[b[i]]++;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) System.out.println((char)i + " " + a[i]);
        }

    }
}

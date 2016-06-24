package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(s1);
        byte[] b = new byte[fis.available()];
        fis.read(b);
        fis = new FileInputStream(s2);
        FileOutputStream fos = new FileOutputStream(s1);
        while (fis.available() > 0){
            int i = fis.read();
            fos.write(i);
        }
        fos.write(b);
        fis.close();
        fos.close();
    }
}

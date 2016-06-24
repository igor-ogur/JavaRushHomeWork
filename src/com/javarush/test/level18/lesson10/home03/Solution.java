package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(s2);
        FileOutputStream fos = new FileOutputStream(s1);
        while (fis.available() > 0){
            int i = fis.read();
            fos.write(i);
        }
        fis = new FileInputStream(s3);
        while (fis.available() > 0){
            int i = fis.read();
            fos.write(i);
        }
        fis.close();
        fos.close();
    }
}

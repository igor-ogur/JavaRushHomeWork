package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1, file2, file3;
        file1 = reader.readLine();
        file2 = reader.readLine();
        file3 = reader.readLine();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos2 = new FileOutputStream(file2);
        FileOutputStream fos3 = new FileOutputStream(file3);
        byte[] buffer = new byte[fis.available()];
        int count = fis.read(buffer);
        if (count % 2 == 0) {
            fos2.write(buffer, 0, count/2);
            fos3.write(buffer, count/2, count/2);
        }else {
            fos2.write(buffer, 0, count/2+1);
            fos3.write(buffer, count/2+1, count/2);
        }
        reader.close();
        fis.close();
        fos2.close();
        fos3.close();
    }
}

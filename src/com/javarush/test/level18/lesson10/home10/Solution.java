package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        TreeSet<File> listFiles = new TreeSet<File>();
        while (!(fileName = reader.readLine()).equals("end")) {
            listFiles.add(new File(fileName));
        }
        reader.close();

        fileName = listFiles.first().getCanonicalPath();
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        FileOutputStream fos = new FileOutputStream(fileName);

        for (File x : listFiles) {
            FileInputStream fis = new FileInputStream(x);
            byte[] b = new byte[fis.available()];
            while (fis.available() > 0) {
                fis.read(b);
                fos.write(b);
            }
            fis.close();

        }

        fos.close();

    }
}

package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader = new BufferedReader(new FileReader(file1));
        FileWriter writer = new FileWriter(file2);
        while (reader.ready()){
            String s = reader.readLine();
            s = s.replaceAll("\\.","!");
            writer.write(s);
        }
        reader.close();
        writer.close();
    }
}

package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();

        FileReader fileReader = new FileReader(f1);
        FileWriter fileWriter = new FileWriter(f2);

        while (fileReader.ready()){
            int i = fileReader.read();
            if (fileReader.ready()) {
                i = fileReader.read();
                fileWriter.write(i);
            }
        }

        fileReader.close();
        fileWriter.close();

    }
}

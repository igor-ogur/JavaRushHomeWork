package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        while (true){
            String s = reader.readLine();
            if (s.equals("exit")) {
                fileOutputStream.write(s.getBytes());
                break;
            }
            //char[] c = s.toCharArray();
            /*for (int i = 0; i < c.length; i++) {
                fileOutputStream.write(c[i]);
            }*/
            fileOutputStream.write(s.getBytes());
            fileOutputStream.write('\n');
        }
        fileOutputStream.close();
    }
}

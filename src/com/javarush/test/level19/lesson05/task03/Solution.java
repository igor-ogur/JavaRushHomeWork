package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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
            String[] str = s.split(" ");
            for (String x : str){
                try{
                    int i = Integer.parseInt(x);
                    writer.write(i+" ");
                }catch (Exception e){

                }
            }
        }
        reader.close();
        writer.close();

    }
}

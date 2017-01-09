package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (true){
            try {
                fileName = reader.readLine();
                FileInputStream fis = new FileInputStream(fileName);
                fis.close();
            } catch (IOException e) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
                System.out.println(fileName);
                break;
            }
        }

    }
}

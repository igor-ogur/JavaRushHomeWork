package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        List<String> list = new ArrayList<String>();
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            for (String x : words) {
                if (x.length() > 6) {
                    list.add(x);
                }
            }
        }
        reader.close();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1) writer.write(list.get(i));
            else writer.write(list.get(i)+",");
        }
        writer.close();
    }
}

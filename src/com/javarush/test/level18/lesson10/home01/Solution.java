package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        Pattern pattern = Pattern.compile("^[a-zA-Z]$");
        int count = 0;
        while (fis.available() > 0){
            String s = String.valueOf((char)fis.read());
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) count++;
        }
        System.out.println(count);
    }
}

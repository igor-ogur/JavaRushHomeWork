package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        final Map<String, Double> map = new TreeMap<String, Double>();
        while (reader.ready()){
            String s = reader.readLine();
            String[] param = s.split(" ");
            if (map.containsKey(param[0])) {
                double d = map.get(param[0]) + Double.parseDouble(param[1]);
                map.put(param[0], d);
            }else map.put(param[0], Double.parseDouble(param[1]));
        }
        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> x : map.entrySet()){
            if (max < x.getValue()) max = x.getValue();
        }
        for (Map.Entry<String, Double> x : map.entrySet()){
            if (x.getValue().equals(max)) System.out.println(x.getKey());
        }
    }
}

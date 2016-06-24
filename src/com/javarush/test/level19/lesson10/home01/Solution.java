package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<String, Double>();
        while (reader.ready()){
            String s = reader.readLine();
            String[] param = s.split(" ");
            if (map.containsKey(param[0])) {
                double d = Double.parseDouble(param[1]) + map.get(param[0]);
                map.put(param[0], d);
            }else map.put(param[0], Double.parseDouble(param[1]));
        }
        reader.close();

        /*final Map<String, Double> finalMap = map;
        map = new TreeMap<String, Double>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (finalMap.get(o1).compareTo(finalMap.get(o2)) == 0) return 1;
                return finalMap.get(o1).compareTo(finalMap.get(o2));
            }
        });
        map.putAll(finalMap);*/
        for (Map.Entry<String, Double> x : map.entrySet()){
            System.out.println(x.getKey()+" "+x.getValue());
        }
    }
}

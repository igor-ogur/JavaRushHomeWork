package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
   public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Ogerchuk", "Galina");
        map.put("Gurko", "Vasiliy");
        map.put("Gerchuk", "Alexandr");
        map.put("Burko", "Tatyana");
        map.put("Vasilenko", "Sergey");
        map.put("Igerchuk", "Igor");
        map.put("Vasilenko", "Andrey");
        map.put("Freymut", "Olga");
        map.put("Sidorov", "Alexandr");
        map.put("Murko", "Olga");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            String value = pair.getValue();
            if (name.equals(value)) {count++;}
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            String key = pair.getKey();
            if (familiya.equals(key)) {count++;}
        }
        return count;

    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Alexandr"));
        System.out.println(getCountTheSameLastName(map, "Gurko"));
    }
}
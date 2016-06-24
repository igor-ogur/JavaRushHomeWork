package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Игерчук", new Date("SEPTEMBER 4 1990"));
        map.put("Потребенко", new Date("August 23 1990"));
        map.put("Дерябина", new Date("April 24 1990"));
        map.put("Красняк", new Date("August 1 1990"));
        map.put("Педченко", new Date("April 12 1990"));
        map.put("Горбунов", new Date("DECEMBER 18 1989"));
        map.put("Дейнека", new Date("SEPTEMBER 15 1990"));
        map.put("Паньковецкий", new Date("DECEMBER 29 1988"));
        map.put("Огерчук", new Date("JULY 14 1968"));

        //Напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Date date = iterator.next().getValue();
            int i = date.getMonth();
            if (i<8 && i>4) iterator.remove();
        }

    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        //for (Map.Entry<String, Date> pair : map.entrySet()){
        //    System.out.println(pair.getKey()+" "+pair.getValue());
        //}
        System.out.println(map);
    }
}

package com.javarush.test.level26.lesson02.task03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T>{
        List<Comparator<T>> comparators;
        public CustomizedComparator (Comparator<T>... comparators) {
            this.comparators = Arrays.asList(comparators);
        }

        @Override
        public int compare(T o1, T o2) {
            for (Comparator<T> c : comparators){
                if (c.compare(o1, o2) != 0) return c.compare(o1, o2);
            }
            return 0;
        }
    }
}

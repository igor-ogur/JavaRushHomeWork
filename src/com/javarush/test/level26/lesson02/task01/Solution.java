package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final double nMediana;
        if (array.length % 2 == 0) nMediana = ((double)array[array.length/2-1] + (double)array[array.length/2])/2;
        else nMediana = array[array.length/2];
        System.out.println(nMediana);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((Math.abs(nMediana-o1) - Math.abs(nMediana-o2)) != 0) return (int) (Math.abs(nMediana-o1) - Math.abs(nMediana-o2));
                return o1 - o2;
            }
        };
        Arrays.sort(array, comparator);
        return array;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        for (int x : sort(a)){
            System.out.print(x + " ");
        }
    }
}

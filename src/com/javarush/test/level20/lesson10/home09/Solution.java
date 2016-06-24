package com.javarush.test.level20.lesson10.home09;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

   /* private void writObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        for (Solution x : edges) {
            oos.writeObject(x);
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        Solution x = (Solution) ois.readObject();
        if (x != null){
            List<Solution> edges = new LinkedList<>();
            while (x != null){
                edges.add(x);
                x = (Solution) ois.readObject();
            }
        }
    }*/
}

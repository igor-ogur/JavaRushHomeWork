package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader1.readLine();
        String file2 = reader1.readLine();
        reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        while (reader1.ready()) {
            list1.add(reader1.readLine());
        }
        while (reader2.ready()) {
            list2.add(reader2.readLine());
        }
        reader1.close();
        reader2.close();
        int i = 0;
        int j = 0;
        while (i<list1.size() || j<list2.size()){
            try {
                if (list1.get(i).equals(list2.get(j))) lines.add(new LineItem(Type.SAME, list1.get(i)));
                else {
                    try {
                        if (!list1.get(i).equals(list2.get(j-1))) lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        else lines.add(new LineItem(Type.SAME, list1.get(i)));
                    }catch (IndexOutOfBoundsException e){
                        try{
                            lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        }catch (IndexOutOfBoundsException ee){

                        }
                    }
                }
            }catch (IndexOutOfBoundsException e){

            }
            i++; j++;
        }

        /*List<LineItem> same = new ArrayList<LineItem>();
        List<LineItem> removed = new ArrayList<LineItem>();
        List<LineItem> added = new ArrayList<LineItem>();

        if (list1.size() >= list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (isSame(list1.get(i), list2)) same.add(new LineItem(Type.SAME, list1.get(i)));
                else {
                    removed.add(new LineItem(Type.REMOVED, list1.get(i)));
                    if ((!list2.get(i).equals("")) && list2.size() > i && isAdded(list2.get(i), list1))
                        added.add(new LineItem(Type.ADDED, list2.get(i)));
                }
            }
        }

        if (list1.size() < list2.size()){
            for (int i = 0; i < list2.size(); i++) {
                if (list1.size() > i) {
                    if (isSame(list1.get(i), list2)) same.add(new LineItem(Type.SAME, list1.get(i)));
                    else {
                        removed.add(new LineItem(Type.REMOVED, list1.get(i)));
                    }
                }
                if ((!list2.get(i).equals("")) && isAdded(list2.get(i), list1)) added.add(new LineItem(Type.ADDED, list2.get(i)));
            }
        }

        while (true){
            if (removed.size()>0) {
                lines.add(removed.get(0));
                removed.remove(0);
            }else {
                if (added.size() > 0) {
                    lines.add(added.get(0));
                    added.remove(0);
                }
            }
            if (same.size()>0) {
                lines.add(same.get(0));
                same.remove(0);
            }
            if (same.size() == 0 && added.size() == 0 && removed.size() == 0) break;
        }*/

        for (LineItem x : lines){
            System.out.println(x.type +" "+ x.line);
        }

    }

    /*static boolean isSame (String s, List<String> list){
        for (int i = 0; i < list.size(); i++) {
            if (s.equals(list.get(i))) {
                list.set(i, "");
                return true;
            }
        }
        return false;
    }

    static boolean isAdded (String s, List<String> list){
        for (int i = 0; i < list.size(); i++) {
            if (s.equals(list.get(i))) return false;
        }
        return true;
    }*/


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

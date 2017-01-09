package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = "";
        String name2 = "";
        try {
            name1 = reader.readLine();
            name2 = reader.readLine();

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(name1), "cp1251"));
            readFromFileToList(reader, allLines);

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(name2), "cp1251"));
            readFromFileToList(reader, forRemoveLines);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String x : allLines){
            System.out.println(x);
        }
        System.out.println();
        for (String x : forRemoveLines){
            System.out.println(x);
        }
        System.out.println();
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            System.out.println("CorruptedDataException");
        }
        for (String x : allLines){
            System.out.println(x);
        }
        System.out.println();
        for (String x : forRemoveLines){
            System.out.println(x);
        }
        System.out.println();

    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            for (String x : forRemoveLines) {
                if (allLines.contains(x)) break;
                else {
                    allLines.clear();
                    throw new CorruptedDataException();
                }
            }
        }
    }

    public static void readFromFileToList(BufferedReader reader, List<String> list) throws IOException {
        String s;
        while ((s = reader.readLine()) != null) {
            list.add(s);
        }
    }
}

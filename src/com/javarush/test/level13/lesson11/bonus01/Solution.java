package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(file));
        ArrayList<Integer> list = new ArrayList<Integer>();
        String s = fileReader.readLine();
        
        while (s != null){
            int i = Integer.parseInt(s);
            //System.out.println(i);
            if (i % 2 == 0) list.add(i); 
            s = fileReader.readLine();
        }
        file.close();
        fileReader.close();
        reader.close();
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j)>list.get(j+1)) {
                    int t = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, t);
                }
            }
        }
        for (int x : list){
            System.out.println(x);
        }

        /*c gitHub
        while (inputStream.ready()) //пока данные читаются
        {
            int i = Integer.parseInt(inputStream.readLine());
            if (i%2==0) list.add(i);
        }

        Collections.sort(list); //сортируем*/
    }
}

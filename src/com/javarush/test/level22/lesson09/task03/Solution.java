package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "cp1251"));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            Collections.addAll(list, reader.readLine().split(" "));
        }

        reader.close();
        String[] words = new String[list.size()];
        words = list.toArray(words);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, words);

        if (words.length == 0) return result;
        if (words.length == 1) return result.append(words[0]);
        int count;
        while (true){
            count = 0;
            Collections.shuffle(list);
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).toLowerCase().charAt(list.get(i).length() - 1) != list.get(i + 1).toLowerCase().charAt(0)) count++;
            }
            if (count == 0) break;
        }


        /*if (words.length > 2) {
            for (int i = 0; i < words.length - 1; i++) {
                if (words[i].toLowerCase().charAt(words[i].length() - 1) != words[i + 1].toLowerCase().charAt(0)) {
                    for (int j = i + 2; j < words.length; j++) {
                        if (words[i].toLowerCase().charAt(words[i].length() - 1) == words[j].toLowerCase().charAt(0)) {
                            String t = words[i + 1];
                            words[i + 1] = words[j];
                            words[j] = t;
                        }
                    }
                }

            }
        }else {
            if (words[0].toLowerCase().charAt(words[0].length() - 1) != words[1].toLowerCase().charAt(0)){
                String t = words[1];
                words[1] = words[0];
                words[0] = t;
            }
        }*/
        for (String x : list){
            result.append(x+" ");
        }
        return result;
    }

}
/*public class Solution {
    public static void main(String[] args) throws IOException
    {
        //...
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready())
        {
            String[] s = reader.readLine().split("\\s");
            Collections.addAll(list, s);
        }
        reader.close();
        String[] words = new String[list.size()];
        words = list.toArray(words);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
        scanner.close();
    }

    public static StringBuilder getLine(String... words)
    {
        ArrayList<String> strings  = new ArrayList<>();
        Collections.addAll(strings, words);
        StringBuilder sb = new StringBuilder();
        if (strings.size() == 0)
            return new StringBuilder();

        sb.append(strings.get(0));
        strings.remove(0);

        while (strings.size()>0){
            for (int i = 0; i < strings.size(); i++) {
                String a = strings.get(i).toUpperCase().toLowerCase();
                String b = sb.toString().toUpperCase().toLowerCase();
                if (a.charAt(0) == b.charAt(sb.length() - 1))
                { // в конец
                    sb.append(" ").append(strings.get(i));
                    strings.remove(i);
                    continue;
                }

                if (b.charAt(0) == a.charAt(a.length() - 1))
                { //в начало
                    sb.insert(0, " ");
                    sb.insert(0, strings.get(i));
                    strings.remove(i);
                }
            }
        }
        return sb;
    }
}*/

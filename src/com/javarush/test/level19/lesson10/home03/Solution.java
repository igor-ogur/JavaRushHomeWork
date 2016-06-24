package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            String s = reader.readLine();
            String[] param = s.split(" ");
            s = param[0];
            if (param.length > 4){
                for (int i = 1; i < param.length-3; i++) {
                    s+=" "+param[i];
                }
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(param[param.length-1]), Integer.parseInt(param[param.length-2])-1, Integer.parseInt(param[param.length-3]));
            Date date = calendar.getTime();
            PEOPLE.add(new Person(s, date));
        }
        reader.close();
        /*for (Person x : PEOPLE){
            System.out.println(x.getName() + " " + x.getBirthday());
        }*/
    }

}

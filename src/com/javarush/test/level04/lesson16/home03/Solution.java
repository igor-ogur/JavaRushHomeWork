package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        Scanner r = new Scanner(System.in);
        int a = 0, s = 0;
        while (true){
            a = r.nextInt();

            if (a == -1) {
                s -= 1;
                System.out.println(s);
                break;}
            s += a;
        }
    }
}

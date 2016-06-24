package com.javarush.test.level08.lesson11.home09;



import java.util.Date;


/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 3 2000"));
    }

    public static boolean isDateOdd(String date) {
        /*SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy", Locale.US);
        Date date1 = df.parse(date);
        Date yearStart = new Date(date1.getYear(), 0, 0);*/
        Date date1 = new Date(date);
        Date yearStart = new Date(date);
        yearStart.setMonth(0);
        yearStart.setDate(1);
        long count = date1.getTime() - yearStart.getTime();
        long l = 24*60*60*1000;
        int days = (int) (count/l);
        if (days % 2 == 1) return false;
        else return true;
    }
}

package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream myPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(myPrintStream);
        testString.printSomething();
        String s = byteArrayOutputStream.toString();
        String[] str = s.split(" ");
        int a = 0, b = 0, c = 0;
        try {
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[2]);
        }catch (Exception e){

        }
        if (str[1].equals("+")) c = a + b;
        if (str[1].equals("*")) c = a * b;
        if (str[1].equals("-")) c = a - b;
        System.setOut(printStream);
        System.out.println(s + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}


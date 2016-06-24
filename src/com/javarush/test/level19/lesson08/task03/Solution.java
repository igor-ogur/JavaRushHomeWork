package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Пример вывода:
12345678
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
        System.setOut(printStream);
        byte[] result = byteArrayOutputStream.toByteArray();
        String endResult = "";
        for (byte x : result){
            try{
                int i = Integer.parseInt(String.valueOf((char) x));
                endResult += i;
            }catch (Exception e){

            }
        }
        System.out.println(endResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}

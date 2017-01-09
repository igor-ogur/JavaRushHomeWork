package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(baos);
        System.setOut(printStream1);
        testString.printSomething();
        System.setOut(printStream);
        String result = baos.toString().toUpperCase();
        System.out.println(result);
        printStream.close();
        baos.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

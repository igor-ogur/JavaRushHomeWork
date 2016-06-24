package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scanner;
        public PersonScannerAdapter (Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String s = scanner.nextLine();

            return null;
        }

        @Override
        public void close() throws IOException {

        }
    }
}

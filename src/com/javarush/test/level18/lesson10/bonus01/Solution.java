package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")){
            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);
            while (fis.available()>0){
                int i = fis.read();
                i++;
                fos.write(i);
            }
            fos.close();
            fis.close();
        }
        if (args[0].equals("-d")){
            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);
            while (fis.available()>0){
                int i = fis.read();
                i--;
                fos.write(i);
            }
            fos.close();
            fis.close();
        }

    }

}

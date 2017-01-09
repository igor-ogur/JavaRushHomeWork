package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int id = 0;
        if (args[0].equals("-c")) {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String s;
            while ((s = reader.readLine()) != null){
                try {
                    String st = s.substring(0,8).trim();
                    if (Integer.parseInt(st) > id) id = Integer.parseInt(st);
                }catch (IndexOutOfBoundsException e){

                }

            }
            reader.close();
            id++;
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "cp1251"));
            writer.write(String.format("%-8d%-30s%-8s%-4s\n",id,args[1],args[2],args[3]));
            writer.close();
        }
    }
}

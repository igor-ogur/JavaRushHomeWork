package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String id = String.format("%-8s",args[1]);
        if (args[0].equals("-u")){
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            byte[] b = (String.format("%-8s%-30s%-8s%-4s\n",args[1],args[2],args[3],args[4])).getBytes("cp1251");
            String line;
            long point;
            while ((line = raf.readLine()) != null){
                long len = line.length();
                if (id.equals(line.substring(0, 8))) {
                    point = raf.getFilePointer();
                    raf.seek(point - len-1);
                    raf.write(b);
                    raf.close();
                    break;
                }
            }
        }
        if (args[0].equals("-d")){
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            //byte[] b = (String.format("%-50s\n",args[1])).getBytes();
            String line;
            long point;
            while ((line = raf.readLine()) != null){
                long len = line.length();
                if (id.equals(line.substring(0, 8))) {
                    point = raf.getFilePointer();
                    raf.seek(point - len-1);
                    for (int i = 0; i <= len; i++) {
                        raf.write(0);
                    }
                    raf.close();
                    break;
                }
            }
        }
    }
}

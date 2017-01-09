package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            for (String x : words){
                char[] word = x.toCharArray();
                for (char c : word){
                    try {
                        Integer.parseInt(String.valueOf(c)); //if (aStringArray.matches(".*\\d.*"))   if (Character.isDigit(c))
                        writer.write(x+" ");
                        break;
                    }catch (Exception e){

                    }
                }
            }
        }
        reader.close();
        writer.close();
    }
}

package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            ReadThread rt = new ReadThread(fileName);
            rt.start();
            try {
                rt.join();
            } catch (InterruptedException e) {

            }
        }
        reader.close();

        /*for (Map.Entry<String, Integer> x : resultMap.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }*/
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        private String fileName;

        @Override
        public void run() {
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available() > 0) {
                    int i = fis.read();
                    if (map.containsKey(i)) map.put(i, map.get(i) + 1);
                    else map.put(i, 1);
                }
                fis.close();
            } catch (IOException e) {
            }

            int max = 0;
            int maxByte = 0;
            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                if (x.getValue() > max) {
                    max = x.getValue();
                    maxByte = x.getKey();
                }
            }
            resultMap.put(fileName, maxByte);


        }
    }
}

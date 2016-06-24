package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    /*public static void main(String[] args) {
        for (Thread thread : threads){
            thread.start();
        }
    }*/

    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            while (true);
        }
    }

    public static class MyThread2 extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                }
                throw new InterruptedException("InterruptedException");
            }catch (InterruptedException e){
                System.out.println("InterruptedException");
            }

        }
    }

    public static class MyThread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println("Ура");
                }
            }catch (InterruptedException e){

            }
        }
    }

    public static class MyThread4 extends Thread implements Message{
        @Override
        public  void showWarning()
        {

            this.interrupt();
            try
            {
                this.join();
            }
            catch(Exception e)
            {

            }

        }

        @Override
        public void run()
        {
            Thread current = Thread.currentThread();
            while(!current.interrupted())
            {

            }


        }
    }

    public static class MyThread5 extends Thread {
        @Override
        public void run() {
            int count = 0;
            String s = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                try {
                    s = reader.readLine();
                    if (!s.equals("N")) count += Integer.parseInt(s);
                    else {
                        System.out.println(count);
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

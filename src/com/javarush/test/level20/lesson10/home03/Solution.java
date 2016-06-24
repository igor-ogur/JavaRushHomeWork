package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";


        public A(){}

        public A(String name) {
            /*this.name += name;*/
            initialize(name);
        }

        public void initialize (String name){
            this.name += name;
        }


    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(name);
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            name = (String) ois.readObject();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.B b = solution.new B("b1");
        System.out.println(b.getClass().getSimpleName());
        System.out.println(b.name);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("in.txt"));
            oos.writeObject(b);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("in.txt"));
            Solution.B bb = (B) ois.readObject();
            System.out.println(bb.getClass().getSimpleName());
            System.out.println(bb.name);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

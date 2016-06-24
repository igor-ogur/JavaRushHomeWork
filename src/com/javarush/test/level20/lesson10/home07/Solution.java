package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;
    //private static final long serialVersionUID = 1L;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
        out.flush();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.fileName = (String) in.readObject();
        this.stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {



        Solution solution = new Solution("out.txt");
        solution.writeObject("Hello!");
        solution.close();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("in.txt"));
        oos.writeObject(solution);
        oos.close();

        System.out.println(solution);
        System.out.println(solution.stream);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("in.txt"));
        Solution solution2 = (Solution) ois.readObject();
        solution2.writeObject("Hi!");
        ois.close();

        System.out.println(solution2);
        System.out.println(solution2.stream);


    }
}

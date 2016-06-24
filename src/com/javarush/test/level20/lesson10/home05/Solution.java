package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject (ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
        }

        private void readObject (ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    /*public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("in.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("in.txt"));

        Person person = new Person("Igor", "Ogerchuk", "Ukraine", Sex.MALE);
        oos.writeObject(person);

        System.out.println(person.firstName);
        System.out.println(person.lastName);
        System.out.println(person.fullName);
        System.out.println(person.greetingString);
        System.out.println(person.country);
        System.out.println(person.sex);
        System.out.println(person.outputStream);
        System.out.println(person.logger);

        Person person2 = (Person) ois.readObject();

        System.out.println(person2.firstName);
        System.out.println(person2.lastName);
        System.out.println(person2.fullName);
        System.out.println(person2.greetingString);
        System.out.println(person2.country);
        System.out.println(person2.sex);
        System.out.println(person2.outputStream);
        System.out.println(person2.logger);
    }*/

    enum Sex {
        MALE,
        FEMALE
    }
}

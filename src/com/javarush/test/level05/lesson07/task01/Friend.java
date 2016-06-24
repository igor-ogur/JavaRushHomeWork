package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    //Напишите тут ваш код
    public void initialize(String name){
        String dogName = name;
    }

    public void initialize(String name, int age){
        String dogName = name;
        int dogAge = age;
    }

    public void initialize(String name, int age, String sex){
        String dogName = name;
        int dogAge = age;
        String dogSex = sex;
    }

    public static void main(String[] args) {

    }

}

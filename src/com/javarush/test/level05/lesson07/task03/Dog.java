package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //Напишите тут ваш код
    public void initialize(String name){
        String dogName = name;
    }

    public void initialize(String name, int growth){
        String dogName = name;
        int dogGrowth = growth;
    }

    public void initialize(String name, int growth, String color){
        String dogName = name;
        int dogGrowth = growth;
        String dogColor = color;
    }

    public static void main(String[] args) {

    }

}

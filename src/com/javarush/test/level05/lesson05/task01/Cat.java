package com.javarush.test.level05.lesson05.task01;

/* Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, String), возраст (age, int), вес (weight, int), сила (strength, int).
*/

public class Cat
{
    //Напишите тут ваш код
    String name;
    int age, weight, strength;
    public static void main (String[] args){
        Cat cat1 = new Cat();
        cat1.name = "Vaska";
        cat1.age = 6;
        cat1.strength = 50;
        cat1.weight = 5;
    }

}

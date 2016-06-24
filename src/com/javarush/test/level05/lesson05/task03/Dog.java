package com.javarush.test.level05.lesson05.task03;

/* Геттеры и сеттеры для класса Dog
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
*/

public class Dog {
    //добавьте переменные класса тут
    String name;
    int age;

    //добавьте геттеры и сеттеры тут
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setName("Joe");
        dog1.setAge(5);

        System.out.println(dog1.getName());
        System.out.println(dog1.getAge());
    }
}

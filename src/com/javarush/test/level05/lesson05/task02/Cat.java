package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat(){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight (Cat anotherCat){
        //Напишите тут ваш код
        if (this.strength+this.weight-this.age>anotherCat.strength+this.weight-this.age) return true;
        else return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Vaska";
        cat1.weight = 5;
        cat1.age = 5;
        cat1.strength = 5;

        Cat cat2 = new Cat();
        cat2.name = "Petka";
        cat2.weight = 10;
        cat2.age = 7;
        cat2.strength = 10;

        System.out.println(cat1.fight(cat2));
        //System.out.println(cat2.fight(cat1));
        //System.out.println(cat1.name+" "+cat1.age+" "+cat1.weight+" "+cat1.strength);
        //System.out.println(cat2.name+" "+cat2.age+" "+cat2.weight+" "+cat2.strength);
    }
}

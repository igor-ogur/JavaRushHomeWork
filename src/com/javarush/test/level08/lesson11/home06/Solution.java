package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        ArrayList<Human> children = new ArrayList<Human>();
        Human child1 = new Human("Alexandr", true, 26, children);
        Human child2 = new Human("Olga", false, 25, children);
        Human child3 = new Human("Igor", true, 24, children);
        children = new ArrayList<Human>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human mother = new Human("Galina", false, 46, children);
        Human father = new Human("Alexandr", true, 52, children);
        children = new ArrayList<Human>();
        children.add(father);
        Human gfather1 = new Human("Andrey", true, 75, children);
        children = new ArrayList<Human>();
        children.add(mother);
        Human gfather2 = new Human("Afanasiy", true, 70, children);
        children = new ArrayList<Human>();
        children.add(father);
        Human gmother1 = new Human("Ekaterina", false, 72, children);
        children = new ArrayList<Human>();
        children.add(mother);
        Human gmother2 = new Human("Ludmila", false, 66, children);

        System.out.println(gfather1);
        System.out.println(gfather2);
        System.out.println(gmother1);
        System.out.println(gmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        //Написать тут ваш код
        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

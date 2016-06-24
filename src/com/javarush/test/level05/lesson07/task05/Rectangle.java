package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //Напишите тут ваш код
    public void initialize(int top, int left, int width, int height){
        int x = left;
        int y = top;
        int w = width;
        int h = height;
    }

    public void initialize(int top, int left){
        int x = left;
        int y = top;
        int w = 0;
        int h = 0;
    }

    public void initialize(int top, int left, int width){
        int x = left;
        int y = top;
        int w = width;
        int h = width;
    }

    public void initialize(Rectangle anotherRec){
        Rectangle newRec = anotherRec;
    }

    public static void main(String[] args) {

    }


}

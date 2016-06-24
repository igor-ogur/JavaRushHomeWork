package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    //Напишите тут ваш код
    public void initialize(int centerX, int centerY, int radius){
        int x = centerX;
        int y = centerY;
        int r = radius;
    }

    public void initialize(int centerX, int centerY, int radius, int width){
        int x = centerX;
        int y = centerY;
        int r = radius;
        int w = width;
    }

    public void initialize(int centerX, int centerY, int radius, int width, String color){
        int x = centerX;
        int y = centerY;
        int r = radius;
        int w = width;
        String clr = color;
    }

    public static void main(String[] args) {

    }


}

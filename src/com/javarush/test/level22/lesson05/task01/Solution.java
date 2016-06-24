package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String result = "";
        try {
            String[] words = string.split(" ");
            for (int i = 1; i < 5; i++) {
                result += words[i] + " ";
            }
            result = result.substring(0, result.length()-1);
        }catch (Exception e){
            throw new TooShortStringException();

        }
        return result;
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static class TooShortStringException extends Exception{
    }
}

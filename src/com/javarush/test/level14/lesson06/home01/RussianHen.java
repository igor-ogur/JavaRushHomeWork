package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 04.02.15.
 */
public class RussianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

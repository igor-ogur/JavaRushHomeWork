package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 04.02.15.
 */
public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 100;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

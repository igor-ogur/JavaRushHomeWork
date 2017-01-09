package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 05.02.15.
 */
public class MoldovanHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 2;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

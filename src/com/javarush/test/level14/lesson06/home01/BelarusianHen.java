package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 05.02.15.
 */
public class BelarusianHen extends Hen {


    /*public BelarusianHen(String country){

    }*/

    @Override
    public int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

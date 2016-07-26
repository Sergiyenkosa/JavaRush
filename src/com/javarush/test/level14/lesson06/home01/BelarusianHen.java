package com.javarush.test.level14.lesson06.home01;

/**
 * Created by s.sergienko on 15.02.2016.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth(){
        return 50;
    }
    protected String getDescription(){
        return super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

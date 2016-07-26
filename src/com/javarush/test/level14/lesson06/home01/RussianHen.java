package com.javarush.test.level14.lesson06.home01;

/**
 * Created by s.sergienko on 15.02.2016.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth(){
        return 10;
    }
    protected String getDescription(){
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

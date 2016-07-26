package com.javarush.test.level14.lesson06.home01;

/**
 * Created by s.sergienko on 15.02.2016.
 */
public abstract class Hen
{
    public abstract int getCountOfEggsPerMonth();
    protected String getDescription(){
        return "Я курица.";
    }
}

package com.javarush.test.level14.lesson08.home09;

/**
 * Created by s.sergienko on 16.02.2016.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName()
    {
        return "USD";
    }
}

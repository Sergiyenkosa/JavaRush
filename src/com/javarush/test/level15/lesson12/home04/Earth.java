package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Sergiy on 18.02.2016.
 */
public class Earth implements Planet
{
    private static Earth earth = new Earth();

    private Earth(){
    }

    public static Earth getInstance(){
        return earth;
    }
}

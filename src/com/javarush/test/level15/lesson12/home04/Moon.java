package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Sergiy on 18.02.2016.
 */
public class Moon implements Planet
{
    private static Moon moon = new Moon();

    public static Moon getInstance(){
        return moon;
    }

    private Moon(){
    }
}

package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Sergiy on 18.02.2016.
 */
public class Sun implements Planet
{

    private static Sun sun = new Sun();

    public static Sun getInstance(){
        return sun;
    }

    private Sun(){
    }
}

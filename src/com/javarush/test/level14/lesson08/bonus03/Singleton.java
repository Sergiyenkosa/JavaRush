package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Sergiy on 16.02.2016.
 */
public class Singleton
{

    static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }

    private Singleton()
    {

    }
}

package com.javarush.test.level14.lesson08.bonus01;

/**
 * Created by s.sergienko on 17.02.2016.
 */
public class Tiger extends Cat
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        cat.getName();
    }

    public String getName(){
        return "Василий Тигранович";
    }

    public String getSuperName(){
        return super.getName();
    }
}

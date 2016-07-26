package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Sergiy on 21.02.2016.
 */
public class Plane implements Flyable
{
    @Override
    public void fly() {

    }

    private int p;

    public Plane(int p) {
        this.p = p;
    }
}

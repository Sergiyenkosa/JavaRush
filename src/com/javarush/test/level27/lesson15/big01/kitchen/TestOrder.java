package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by s.sergienko on 06.09.2016.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        Dish[] dishs = Dish.values();
        for (int i = 3; i > 0; i--) {
            dishes.add(dishs[ThreadLocalRandom.current().nextInt(0, dishs.length)]);
        }
    }
}

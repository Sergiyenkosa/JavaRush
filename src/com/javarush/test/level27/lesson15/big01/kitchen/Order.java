package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by s.sergienko on 09.08.2016.
 */
public class Order {

    protected List<Dish> dishes;

    private Tablet tablet;

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public Tablet getTablet()
    {
        return tablet;
    }

    public int getTotalCookingTime() {
        int i = 0;
        for (Dish dish : dishes) {
            i += dish.getDuration();
        }
        return i;
    }

    @Override
    public String toString() {
        if (dishes.isEmpty())
            return "";
        else
            return String.format("Your order: %s of %s", dishes, tablet);
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }
}

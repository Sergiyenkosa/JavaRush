package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

/**
 * Created by s.sergienko on 13.09.2016.
 */
public class Controller {
    private Model model;

    public Controller(Model model)
    {
        this.model = model;
        if (model == null) {
            throw new IllegalArgumentException();
        }
    }

    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }
}

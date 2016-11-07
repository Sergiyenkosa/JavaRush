package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by s.sergienko on 13.09.2016.
 */
public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        view.setController(new Controller(new Model(view, new Provider(new WorkStrategy()),
                new Provider(new RabotaStrategy()), new Provider(new HHStrategy()), new Provider(new MoikrugStrategy()))));
        view.userCitySelectEmulationMethod();
    }
}
package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by s.sergienko on 20.07.2016.
 */
public final class CurrencyManipulatorFactory {
    static Map<String, CurrencyManipulator> manipulatorFactoryMap = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (manipulatorFactoryMap.containsKey(currencyCode)) {
            return manipulatorFactoryMap.get(currencyCode);
        }
        else {
            manipulatorFactoryMap.put(currencyCode, new CurrencyManipulator(currencyCode));
            return manipulatorFactoryMap.get(currencyCode);
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return manipulatorFactoryMap.values();
    }
}

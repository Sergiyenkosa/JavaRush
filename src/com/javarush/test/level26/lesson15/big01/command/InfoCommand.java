package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by s.sergienko on 20.07.2016.
 */
class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {

        ConsoleHelper.writeMessage(res.getString("before"));

        boolean moneyAvailable = false;

        for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {

            if (currencyManipulator.hasMoney()) {

                if (currencyManipulator.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
                    moneyAvailable = true;
                }
            }
        }

        if (!moneyAvailable) ConsoleHelper.writeMessage(res.getString("no.money"));

    }
}

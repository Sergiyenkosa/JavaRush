package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by s.sergienko on 20.07.2016.
 */
public class CashMachine {

    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args) {

        try {

            Locale.setDefault(Locale.ENGLISH);

            CommandExecutor.execute(Operation.LOGIN);

            Operation operation;

            while (true) {
                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);

            }
        }
        catch (InterruptOperationException e) {

        }


    }
}

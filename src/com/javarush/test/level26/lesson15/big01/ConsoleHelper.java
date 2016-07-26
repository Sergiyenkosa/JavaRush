package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by s.sergienko on 20.07.2016.
 */
public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common_en");

    public static Operation askOperation() throws InterruptOperationException {

        writeMessage(res.getString("choose.operation"));

        while (true){
            try {
                Operation operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));

                writeMessage(res.getString("operation." + operation.toString()));

                return operation;
            }
            catch (IllegalArgumentException e) {

                writeMessage(res.getString("invalid.data"));

                continue;
            }

        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {

        writeMessage(res.getString("choose.currency.code"));

        while (true) {
            String s = readString();

            if (s.length()==3) {
                return s.toUpperCase();
            }
            else {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        while (true) {
            String s = readString();

            try {
                String[] strings = s.split(" ");

                if (strings.length != 2) {
                    throw new Exception();
                }

                for (String iterator : strings){
                    int i = Integer.parseInt(iterator);
                    if (i <= 0){
                        throw new Exception();
                    }
                }
            }
            catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            return s.split(" ");
        }
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {

        String s = "";

        try {
            s = reader.readLine();
        }
        catch (IOException e) {
        }

        if (s.toUpperCase().equals("EXIT")) {
            printExitMessage();
            throw new InterruptOperationException();
        }
        else {
            return s;
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}

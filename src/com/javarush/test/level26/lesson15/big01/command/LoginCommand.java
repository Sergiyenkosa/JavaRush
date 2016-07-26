package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by s.sergienko on 25.07.2016.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));

        String cardNumber;
        String pin;

        while (true) {

            ConsoleHelper.writeMessage(res.getString("specify.data"));

            cardNumber = ConsoleHelper.readString();

            if (cardNumber.length() != 12) {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }

            pin = ConsoleHelper.readString();

            if (pin.length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }


            if (validCreditCards.containsKey(cardNumber) && validCreditCards.getObject(cardNumber).equals(pin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                break;
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
            }
        }
    }
}

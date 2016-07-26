package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by s.sergienko on 20.07.2016.
 */
class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = "";

        boolean b = true;

        while (b) {
            currencyCode = ConsoleHelper.askCurrencyCode();

            for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                if (currencyManipulator.getCurrencyCode().equals(currencyCode)) {
                    b = false;
                }
            }
        }

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        int sum = 0;

        while (true) {

            try {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));

                int i = Integer.parseInt(ConsoleHelper.readString());
                if (i <= 0) {
                    throw new Exception();
                }
                else {
                    sum = i;
                }
            }
            catch (Exception e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }

            if (!currencyManipulator.isAmountAvailable(sum)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }

            try {
                Map<Integer, Integer> map = currencyManipulator.withdrawAmount(sum);

                List<Integer> list = new LinkedList<>();

                list.addAll(map.keySet());
                Collections.sort(list);

                for (int i = list.size()-1; i > -1; i--) {
                    ConsoleHelper.writeMessage("    " + String.format(res.getString("success.format"), list.get(i), map.get(list.get(i))));
                }
            }
            catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, currencyCode));

            break;
        }
    }
}

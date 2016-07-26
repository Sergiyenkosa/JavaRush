package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by s.sergienko on 20.07.2016.
 */
class ExitCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");

    @Override
    public void execute() throws InterruptOperationException {
        String s;

        do {
            ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

            s = ConsoleHelper.readString();

            if (s.equals(res.getString("yes"))) {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
                throw new InterruptOperationException();
            }
            else if (s.equals("n")) {
                break;
            }
        }
        while (!s.equals("y"));
    }
}

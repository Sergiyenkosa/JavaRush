package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by s.sergienko on 09.08.2016.
 */
public class Waitor implements Runnable {

    private LinkedBlockingQueue<Object[]> queueForWaitor;

    public void setQueueForWaitor(LinkedBlockingQueue<Object[]> queueForWaitor)
    {
        this.queueForWaitor = queueForWaitor;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (!queueForWaitor.isEmpty()) {
                    Object[] objects = queueForWaitor.take();
                    ConsoleHelper.writeMessage(objects[1] + " was cooked by " + objects[0]);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 100));
                }

                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}
package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by s.sergienko on 09.08.2016.
 */
public class Cook extends Observable implements Runnable{

    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;
    private LinkedBlockingQueue<Object[]> queueForWaitor;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy()
    {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    public void setQueueForWaitor(LinkedBlockingQueue<Object[]> queueForWaitor) {
        this.queueForWaitor = queueForWaitor;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) throws InterruptedException
    {
        busy = true;

        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));

        Thread.sleep(order.getTotalCookingTime()*10);

        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));

        queueForWaitor.add(new Object[] {this, order});

        busy = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try
            {
                if (!isBusy() & !queue.isEmpty()) {
                    startCookingOrder(queue.take());
                }

                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}

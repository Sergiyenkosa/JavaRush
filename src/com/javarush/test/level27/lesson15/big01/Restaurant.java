package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by s.sergienko on 09.08.2016.
 */
public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    private static final LinkedBlockingQueue<Object[]> queueForWaitor = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException
    {
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(queue);
        cook1.setQueueForWaitor(queueForWaitor);

        Cook cook2 = new Cook("Diego");
        cook2.setQueue(queue);
        cook2.setQueueForWaitor(queueForWaitor);

        Waitor waitor = new Waitor();
        waitor.setQueueForWaitor(queueForWaitor);

        Thread threadWaitor = new Thread(waitor);
        threadWaitor.start();

        Thread threadCook1 = new Thread(cook1);
        threadCook1.start();
        Thread threadCook2 = new Thread(cook2);
        threadCook2.start();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i+1);
            tablet.setQueue(queue);
            tablets.add(tablet);
        }

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();

        try
        {
            Thread.sleep(11000);
            thread.interrupt();
            thread.join();
            threadCook1.interrupt();
            threadCook1.join();
            threadCook2.interrupt();
            threadCook2.join();
            threadWaitor.interrupt();
            threadWaitor.join();
        }
        catch (InterruptedException ignored) {
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printNoAvailableVideoSet();
    }
}

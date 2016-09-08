package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by s.sergienko on 09.08.2016.
 */
public class Tablet
{
    public final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createTestOrder() {
        try
        {
            Order order = new TestOrder(this);
            creatingOrder(order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void creatingOrder(Order order)
    {
        ConsoleHelper.writeMessage(order.toString());

        if (!order.isEmpty()) {
            queue.add(order);
            try
            {
                new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
            }
            catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    public void createOrder()
    {
        try
        {
            Order order = new Order(this);
            creatingOrder(order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString()
    {
        return String.format("Tablet{number=%d}", number);
    }
}

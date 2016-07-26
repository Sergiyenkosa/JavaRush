package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by s.sergienko on 19.07.2016.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; ; i++){
                System.out.println("Some text for " + i);
                Thread.sleep(500);
            }

        }
        catch (InterruptedException e)
        {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}

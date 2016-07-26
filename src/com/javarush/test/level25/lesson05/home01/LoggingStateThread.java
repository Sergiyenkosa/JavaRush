package com.javarush.test.level25.lesson05.home01;

/**
 * Created by s.sergienko on 29.06.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread thread;

    public LoggingStateThread(Thread thread)
    {
        System.out.println(thread.getState());
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        State s = thread.getState();
        if (!s.equals(State.NEW)){
            System.out.println(s);
        }

        while (true){
            State a;

            if (!(a = thread.getState()).equals(s)){
                System.out.println(a);
                s = a;
            }
        }
    }
}

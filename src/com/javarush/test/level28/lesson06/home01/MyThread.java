package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by s.sergienko on 12.09.2016.
 */
public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(1);

    public MyThread() {
        this.setPriority(priority.get() < 10 ? priority.getAndIncrement() : priority.getAndSet(1));
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);

        if (priority.get() < 10) {
            if (priority.get() > group.getMaxPriority()) {
                this.setPriority(group.getMaxPriority());
            }
            else {
                this.setPriority(priority.get());
            }
            priority.incrementAndGet();
        }
        else {
            this.setPriority(priority.getAndSet(1));
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);

        if (priority.get() < 10) {
            if (priority.get() > group.getMaxPriority()) {
                this.setPriority(group.getMaxPriority());
            }
            else {
                this.setPriority(priority.get());
            }
            priority.incrementAndGet();
        }
        else {
            this.setPriority(priority.getAndSet(1));
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);

        if (priority.get() < 10) {
            if (priority.get() > group.getMaxPriority()) {
                this.setPriority(group.getMaxPriority());
            }
            else {
                this.setPriority(priority.get());
            }
            priority.incrementAndGet();
        }
        else {
            this.setPriority(priority.getAndSet(1));
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);

        if (priority.get() < 10) {
            if (priority.get() > group.getMaxPriority()) {
                this.setPriority(group.getMaxPriority());
            }
            else {
                this.setPriority(priority.get());
            }
            priority.incrementAndGet();
        }
        else {
            this.setPriority(priority.getAndSet(1));
        }
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(priority.get() < 10 ? priority.getAndIncrement() : priority.getAndSet(1));
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(priority.get() < 10 ? priority.getAndIncrement() : priority.getAndSet(1));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(priority.get() < 10 ? priority.getAndIncrement() : priority.getAndSet(1));
    }
}

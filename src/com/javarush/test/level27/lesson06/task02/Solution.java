package com.javarush.test.level27.lesson06.task02;

/* Определяем порядок захвата монитора. Сложная.
Реализуйте логику метода isNormalLockOrder, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks - порядку
передаваемых в него аргументов. Должно выполняться условие:
для разных объектов o1 и o2 isNormalLockOrder(o1, o2) != isNormalLockOrder(o2, o1), для одинаковых объектов одинаковый результат
Метод main не участвует в тестировании.
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        //следующие 4 строки в тестах имеют другую реализацию
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;

        synchronized (firstLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }

            synchronized (secondLock) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here

        synchronized (solution) {
            Thread thread1 = new Thread() {//thread catch o1 monitor
                @Override
                public void run()
                {
                    synchronized (o1) {
                        while (!isInterrupted());
                    }
                }
            };

            thread1.start();

            Thread.sleep(50);

            Thread thread2 = new Thread() {//thread do method s...
                @Override
                public void run()
                {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            };

            thread2.start();

            Thread.sleep(50);

            Thread thread3 = new Thread() {//if method s... starts from catching o1 monitor, the thread catching o2 and leaving it else if method s... starts from catching o2 monitor thread will block;
                @Override
                public void run()
                {
                    synchronized (o2) {
                    }
                }
            };

            thread3.start();

            Thread.sleep(50);

            Thread.State state = thread3.getState();// state of tread 3;

            thread1.interrupt();//leave o1 monitor for doing method s...

            if (state.equals(Thread.State.BLOCKED)) {
                return false;
            }
            else return true;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o1, o2); //expected boolean b
                } catch (Exception ignored) {
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o2, o1); //expected boolean !b
                } catch (Exception ignored) {
                }
            }
        }.start();
    }
}

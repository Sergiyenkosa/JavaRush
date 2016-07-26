package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код

        HashSet<Integer> n = new HashSet<>();
        n.add(1);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(5);
        n.add(6);
        n.add(7);
        n.add(8);
        n.add(9);
        n.add(10);
        n.add(11);
        n.add(12);
        n.add(13);
        n.add(14);
        n.add(15);
        n.add(16);
        n.add(17);
        n.add(18);
        n.add(19);
        n.add(20);

        return n;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код

        Iterator<Integer> i = set.iterator();
        while (i.hasNext()){
            int a = i.next();
            if (a > 10) i.remove();
        }

        return set;

    }
}

package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. пункт 3

        int i = 1;

        for (Object a : cats){
            if (i == cats.size())cats.remove(a);
            i = i + 1;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2

        Set<Cat> cats = new HashSet<>();

        Cat a = new Cat();
        Cat b = new Cat();
        Cat c = new Cat();

        cats.add(a);
        cats.add(b);
        cats.add(c);

        return cats;
    }

    public static void printCats(Set<Cat> cats)
    {
        // пункт 4
        for (Object a: cats) System.out.println(a);

    }

    public static class Cat{

}
    // пункт 1
}

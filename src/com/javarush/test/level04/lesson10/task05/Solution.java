package com.javarush.test.level04.lesson10.task05;

import java.io.*;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while.
Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int a = 1;
        int b = 1;
        int c = 10;
        while (a%c!=0&&!(c>100))
        {
            System.out.print(a+" ");
            a=a+b;
            while (a==c&&!(c>100))
            {
                System.out.println(c);
                a=a+b;
                a=a/10+1;
                b=b+1;
                c=c+10;
            }
        }
    }
}

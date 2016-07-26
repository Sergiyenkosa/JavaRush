package com.javarush.test.level04.lesson13.task03;

import java.io.*;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int b = 1;

        for (int a = 1; a <=10; a++){
            for (int c = b; c<=10; c++){
                System.out.print("8");
            }
            System.out.println("");
            b = b + 1;
        }

    }
}

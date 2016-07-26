package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String a1 = reader.readLine();
                int b1 = Integer.parseInt(a1);
            String a2 = reader.readLine();
                int b2 = Integer.parseInt(a2);
            String a3 = reader.readLine();
                int b3 = Integer.parseInt(a3);

        int c = 0;

        if (b1>0)
            c = 1;
        if (b2>0)
            c = c + 1;
        if (b3>0)
            c = c + 1;

        System.out.println(c);
    }
}

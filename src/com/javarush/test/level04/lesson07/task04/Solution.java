package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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

        int c1 = 0;
        int c2 = 0;

        if (b1<0)
            c1 = c1 + 1;
                else
                    c2 = c2 + 1;
        if (b2<0)
            c1 = c1 +1;
                else
                    c2 = c2 + 1;
        if (b3<0)
            c1 = c1 + 1;
                else
                    c2 = c2 + 1;

        System.out.println("количество отрицательных чисел: " + c1);
        System.out.println("количество положительных чисел: " + c2);





    }
}

package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        String a = "S";
        int b = 1;

        while (b<=100&&!(b%10==0))
        {
            System.out.print(a);
            b++;
            while (b%10==0)
            {
                System.out.println(a);
                b++;
            }




        }


    }
}

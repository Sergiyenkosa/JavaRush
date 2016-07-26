package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String a1 = reader.readLine();
                int b1 = Integer.parseInt(a1);
            String a2 = reader.readLine();
                int b2 = Integer.parseInt(a2);
            String a3 = reader.readLine();
                int b3 = Integer.parseInt(a3);

        if ((b1>b2 & b1<b3)||(b1<b2 & b1>b3))
            System.out.println(b1);
        else if ((b2>b1 & b2<b3)||(b2<b1 & b2>b3))
            System.out.println(b2);
        else if ((b3>b1 & b3<b2)||(b3<b1 & b3>b2))
            System.out.println(b3);
    }
}

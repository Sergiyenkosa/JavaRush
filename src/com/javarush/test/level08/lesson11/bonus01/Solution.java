package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> m = new HashMap<String, Integer>();

        m.put("January", 1);
        m.put("February", 2);
        m.put("March", 3);
        m.put("April", 4);
        m.put("May", 5);
        m.put("June", 6);
        m.put("July", 7);
        m.put("August", 8);
        m.put("September", 9);
        m.put("October", 10);
        m.put("November", 11);
        m.put("December", 12);

        String s = reader.readLine();
        System.out.println(s + " is " + m.get(s) + " month");
    }

}

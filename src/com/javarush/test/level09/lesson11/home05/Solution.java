package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        ArrayList<String> c = new ArrayList<>();

        for (int i = 0; i < s.length(); i++){
            if (s.substring(i,i+1).equals(" "));
            else
                a.add(s.substring(i, i+1));
        }

        for (int i = 0; i < a.size(); i++){
            if (isVowel(a.get(i).charAt(0)) == true)
                b.add(a.get(i));
            else c.add(a.get(i));
        }

        for (int i = 0; i < b.size(); i++)
            if (i < b.size()-1)
                System.out.print(b.get(i) + " ");
            else System.out.println(b.get(i));

        for (int i = 0; i < c.size(); i++)
            if (i < c.size()-1)
                System.out.print(c.get(i) + " ");
            else System.out.println(c.get(i));*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a = reader.readLine();
        String b = "";
        String c = "";

        char[] d = a.toCharArray();

        for (int i = 0; i < d.length; i++){
            if (d[i] == ' ')
                continue;
            if (isVowel(d[i]) == true)
                b += d[i]+" ";
            else
                c += d[i]+" ";
        }

        b = b.trim();
        c = c.trim();

        System.out.println(b);
        System.out.println(c);
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}

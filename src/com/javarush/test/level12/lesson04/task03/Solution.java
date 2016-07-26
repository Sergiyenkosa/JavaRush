package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    void print(int i){
        System.out.println();
    }

   void print(Integer i){
        System.out.println(i);
    }

    void print(String s){
        System.out.println(s);
    }

    void print(byte b){
        System.out.println(b);
    }

    void print(Byte b){
        System.out.println(b);
    }
}

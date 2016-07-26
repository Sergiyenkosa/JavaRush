package com.javarush.test.level09.lesson11.bonus03;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        Map<Integer, String> mPosition = new HashMap<>();
        ArrayList<String> sArray = new ArrayList<>();
        ArrayList<Integer> iArray = new ArrayList<>();

        for (int i = 0; i < array.length; i++){
            if (isNumber(array[i])==true){
                mPosition.put(i, "int");
                iArray.add(Integer.parseInt(array[i]));
            }
            else{
                mPosition.put(i, "str");
                sArray.add(array[i]);
            }
        }

        Collections.sort(sArray);
        Collections.sort(iArray, Collections.reverseOrder());

        for (int i = 0; i < mPosition.size(); i++){
            if(mPosition.get(i).equals("str")){
                array[i] = sArray.get(0);
                sArray.remove(0);
            }
            else{
                array[i] = iArray.get(0).toString();
                iArray.remove(0);
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}

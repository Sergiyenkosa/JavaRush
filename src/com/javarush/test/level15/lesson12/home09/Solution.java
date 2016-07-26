package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        int begin = url.indexOf('?');

        url = url.substring(begin + 1);

        String p = "";

        List<String> list = new ArrayList<>();

        while (true){
            String s = "";

            int i = url.indexOf('&');

            if (i != -1)
                s = url.substring(0, i);
                else
                    s = url;

            if (s.startsWith("obj=")){
                int middle = s.indexOf('=');
                p += " " + s.substring(0, middle);
                list.add(s.substring(middle+1, s.length()));
            }
                else if (s.indexOf('=') != -1){
                    int middle = s.indexOf('=');
                    p += " " + s.substring(0, middle);
                }
                    else
                        p += " " + s;

            if (i != -1)
                url = url.substring(i + 1);
                else
                    break;
        }

        System.out.println(p.substring(1));

        if (!(list.isEmpty())){
            for (int i = 0; i < list.size(); i++){
                try{
                    alert(Double.parseDouble(list.get(i)));
                }
                catch (Exception e){
                    alert(list.get(i));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

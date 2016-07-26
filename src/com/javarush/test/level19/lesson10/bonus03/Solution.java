package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));

        bufferedReader.close();

        String s = "";

        while (reader.ready()){
            s += reader.readLine();
        }

        reader.close();

        Map<Integer, String> map = new TreeMap<>();

        int value = 0;

        while (value!=-1){
            map.put(s.indexOf("<"+args[0], value), "s");
            value = s.indexOf("<"+args[0], value+1);
        }

        value = 0;

        while (value!=-1){
            map.put(s.indexOf("</"+args[0], value), "a");
            value = s.indexOf("</"+args[0], value+1);
        }

        boolean b = true;

        while (b){

            int s1 = 0;
            int a1 = 0;

            int start = 0;
            for (Map.Entry<Integer, String> entry : map.entrySet()){
                if(entry.getValue().equals("s") && start == 0){
                    s1 = entry.getKey();
                    start = 2;
                }
                else if(entry.getValue().equals("s") && start != 0){
                    start = start-1;
                }
                else if(entry.getValue().equals("a") && start == 2){
                    a1 = entry.getKey();
                    break;
                }
                else if(entry.getValue().equals("a") && start !=2){
                    start = start+1;
                }
            }

            System.out.println(s.substring(s1, a1+3+args[0].length()));
            map.remove(s1);
            map.remove(a1);
            if (map.isEmpty()){
                b = false;
            }
            s1 = 0;
            a1 = 0;
        }
    }
}

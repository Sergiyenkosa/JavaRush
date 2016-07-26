package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader in = new FileReader(reader.readLine());

        reader.close();

        String s = "";

        int count = 0;

        while (in.ready()){

            int i = in.read();

            if(i >= 97 && i <=122){
                s += (char)i;
            }
            else {
                if(s.equals("world")){
                    count = count + 1;
                    s = "";
                }
                else {
                    s = "";
                }
            }
        }

        in.close();

        System.out.println(count);
    }
}

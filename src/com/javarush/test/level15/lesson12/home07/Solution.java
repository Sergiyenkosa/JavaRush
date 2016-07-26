package com.javarush.test.level15.lesson12.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {

        List l = new ArrayList();

        String s = "";

        try
        {
            FileInputStream stream = new FileInputStream(Constants.FILE_NAME);

            while (stream.available() > 0){
                int i = stream.read();
                l.add((char)i);
            }

            stream.close();

        }
        catch (Exception e)
        {
        }

        for (int i = 0; i < l.size(); i++){
            if (l.get(i).equals('\n')){
                lines.add(s);
                s = "";
            }
                    else
                        s += l.get(i).toString();
        }

        if (!(s.equals(""))){
            lines.add(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}

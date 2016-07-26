package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        List<String> list = new ArrayList<>();

        while (true){
            String a = reader.readLine();
            if (a.equals("exit")){
                a += "\n";
            list.add(a);
                break;
            }
            else{
                a += "\n";
                list.add(a);
            }
        }

        reader.close();

        OutputStream out = new FileOutputStream(s);

        for (int i = 0; i < list.size(); i++){
            out.write(list.get(i).getBytes());
        }

        out.close();
    }
}

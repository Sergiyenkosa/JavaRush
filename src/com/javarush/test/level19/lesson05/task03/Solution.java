package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader in = new FileReader(reader.readLine());

        FileWriter out = new FileWriter(reader.readLine());

        reader.close();

        String s = "";

        String result = "";

        while (in.ready()){

            Character c = (char) in.read();

            if (!c.equals(' ')){
                s += c;
            }

            else {
                try{
                    result += Integer.parseInt(s) + " ";
                    s = "";
                }

                catch (NumberFormatException n){
                    s = "";
                }


            }
        }

        if (!s.equals("")){
            try{
                result += Integer.parseInt(s);
            }

            catch (NumberFormatException e){
            }
        }

        if(result.endsWith(" ")){
            result.substring(0, result.length()-1);
        }

        out.write(result);

        out.close();
        in.close();
    }
}

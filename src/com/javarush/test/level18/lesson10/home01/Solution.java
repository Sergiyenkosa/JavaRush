package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int i = 0;

        if (args.length > 0){
            FileInputStream inputStream = new FileInputStream(args[0]);

            while (inputStream.available() > 0){

                int a = inputStream.read();

                if(a >= Integer.valueOf('A') && a <= Integer.valueOf('Z') || a >= Integer.valueOf('a') && a <= Integer.valueOf('z')){
                    i++;
                }

            }

            inputStream.close();
        }

        System.out.println(i);
    }
}

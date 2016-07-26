package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);

        long l = 0;

        while (inputStream.available() > 0){
            int i = inputStream.read();
            if (i == 054){
                l = l+1;
            }
        }

        inputStream.close();

        System.out.println(l);
    }
}

package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file);

        int b = 0;

        while (inputStream.available() > 0){
            int a = inputStream.read();
            if (a > b){
                b = a;
            }
        }

        System.out.println(b);

        reader.close();
        inputStream.close();
    }
}

package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0){
            int b = inputStream.read();

            if (map.containsKey(b)){
                int i = map.get(b);
                map.put(b, i+1);
            }

            else{
                map.put(b, 1);
            }
        }

        long l = Long.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() < l){
                l = entry.getValue();
            }
        }

        String s = "";

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == l){
                s += " " + entry.getKey();
            }
        }

        s = s.substring(1);

        System.out.println(s);
    }
}

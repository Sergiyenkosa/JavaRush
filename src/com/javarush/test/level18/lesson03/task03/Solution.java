package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

        Map<Integer, Integer> map = new HashMap<>();

        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0){

            int i = inputStream.read();

            if (map.containsKey(i)){
                int a = map.get(i);
                map.put(i, a+1);
            }

            else {
                map.put(i, 1);
            }
        }

        inputStream.close();

        long l = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > l){
                l = entry.getValue();
            }
        }

        String result = "";

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == l){
                result += " " + entry.getKey();
            }
        }

        result = result.substring(1);

        System.out.println(result);
    }
}

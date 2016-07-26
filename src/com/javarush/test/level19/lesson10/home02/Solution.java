package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> map = new HashMap<String, Double>();

        Double d = Double.MIN_VALUE;

        while (reader.ready()){

            Double d1;

            String s = reader.readLine();

            String[] strings = s.split(" ");

            if(map.containsKey(strings[0])){
                map.put(strings[0],d1 =  (map.get(strings[0]) + Double.parseDouble(strings[1])));
            }

            else {
                map.put(strings[0], d1 = (Double.parseDouble(strings[1])));
            }

            if(d < d1){
                d = d1;

            }
        }

        reader.close();

        for (Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() == d){
                System.out.println(entry.getKey());
            }
        }
    }
}

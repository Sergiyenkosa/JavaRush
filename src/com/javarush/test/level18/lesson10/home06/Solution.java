package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String file = null;

        if(args.length != 0){
            file = args[0];
        }

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        FileInputStream in = new FileInputStream(file);

        while (in.available() > 0){

            Integer i = in.read();

            if (i >= 0 && i <= 255){
                if (map.containsKey(i)){
                    map.put(i, map.get(i)+1);
                }
                else {
                    map.put(i, 1);
                }
            }
        }

        in.close();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int i = entry.getKey();
            char c = (char)i;
            System.out.println(c + " " + entry.getValue());
        }
    }
}

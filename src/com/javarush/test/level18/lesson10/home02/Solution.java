package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        int s = 0;
        int c = 0;

        if (args.length > 0){
            FileInputStream in = new FileInputStream(args[0]);

            while (in.available() > 0){
                int a = in.read();

                if (a == Integer.valueOf(' ')){
                    s++;
                    c++;
                }
                else {
                    c++;
                }
            }

            in.close();
        }



        double d = 0;

        if(c!=0){
            d = (double) s / c * 100;
        }

        System.out.printf("%.2f", d);
    }
}

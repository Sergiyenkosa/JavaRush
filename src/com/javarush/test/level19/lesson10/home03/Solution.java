package com.javarush.test.level19.lesson10.home03;

import sun.util.calendar.JulianCalendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()){
            String s = reader.readLine();

            String[] strings = s.split(" ");

            int year = Integer.parseInt(strings[strings.length-1]);
            int month = Integer.parseInt(strings[strings.length-2]);
            int day = Integer.parseInt(strings[strings.length-3]);

            String mane = s.substring(0, (s.length() - (strings[strings.length-1].length()+strings[strings.length-2].length()+strings[strings.length-3].length()+3)));

            Calendar calendar = new GregorianCalendar(year, month-1, day);

            Date date = calendar.getTime();

            PEOPLE.add(new Person(mane, date));
        }

        reader.close();
    }

}

package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Пупкин", "Вася");
        map.put("Пяточкин", "Петрик");
        map.put("Вакарчук", "Славик");
        map.put("Порошенко", "Петр");
        map.put("Обама", "Барак");
        map.put("Пугачева", "Алла");
        map.put("Ауэрман", "Надя");
        map.put("Элтон", "Джон");
        map.put("Старк", "Тонни");
        map.put("Норрис", "Чак");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код

        /*int a = 0;
        for (String s : map.values())
            if (s.equals(name)) a = 1;

        return a;*/

        int a = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (name.equals(pair.getValue())) a = a + 1;
        }

        return a;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код

        /*int a = 0;
        for (String s : map.keySet())
            if (s.equals(lastName)) a = 1;

        return a;*/

        int b = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (lastName.equals(pair.getKey())) b = b + 1;
        }

        return b;

    }
}

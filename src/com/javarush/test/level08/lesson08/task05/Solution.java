package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    /*public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<String, String>(createMap());
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }*/

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Пупкин", "Вася");
        map.put("Пяточкин", "Петрик");
        map.put("Вакарчук", "Славик");
        map.put("Порошенко", "Петр");
        map.put("Обама", "Барак");
        map.put("Пугачева", "Алла");
        map.put("Ауэрман", "Надя");
        map.put("Элтон", "Джон");
        map.put("Старк", "Вася");
        map.put("Норрис", "Чак");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код

        HashMap<String, String> copy1 = new HashMap<String, String>(map);
        HashMap<String, String> copy2 = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair1: copy1.entrySet()){
            int i = 0;
            for (Map.Entry<String, String> pair2: copy2.entrySet()){
                if (pair1.getValue().equals(pair2.getValue())) i = i + 1;
            }
            if (i > 1){
                map.remove(pair1.getKey());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}

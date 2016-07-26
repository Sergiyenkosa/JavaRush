package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код

        map.put("Downey", new Date("APRIL 4 1965"));
        map.put("Jolie", new Date("JUNE 4 1975"));
        map.put("Schwarzenegger", new Date("JULY 30 1947"));
        map.put("Costner", new Date("JANUARY 18, 1955"));
        map.put("Anderson", new Date("AUGUST 9 1968"));
        map.put("Lively", new Date("AUGUST 25 1987"));
        map.put("Johansson", new Date("NOVEMBER 22 1984"));
        map.put("Brosnan", new Date("MAY 16 1953"));
        map.put("Knightley", new Date("MARCH 26 1985"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();

            Date a = pair.getValue();
            int month = a.getMonth();
            System.out.println(month);
            if (month > 4 & month < 8) iterator.remove();
        }


    }
}

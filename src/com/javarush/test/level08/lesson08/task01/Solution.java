package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> s = new HashSet<String>();
        s.add("Лоб");
        s.add("Луна");
        s.add("Лом");
        s.add("Лик");
        s.add("Липа");
        s.add("Лапа");
        s.add("Лиса");
        s.add("Лист");
        s.add("Лодка");
        s.add("Ложка");
        s.add("Линия");
        s.add("Линолиум");
        s.add("Луг");
        s.add("Лось");
        s.add("Лапоть");
        s.add("Лис");
        s.add("Ласка");
        s.add("Лопата");
        s.add("Лопасть");
        s.add("Локон");
        return s;


    }
}

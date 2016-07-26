package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        int count = tokenizer.countTokens();

        String[] strings = new String[count];

        for (int i = 0; i < count; i++){
            strings[i] = tokenizer.nextToken();
        }

        return strings;
    }
}

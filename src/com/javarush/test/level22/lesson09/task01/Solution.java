package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine())))
        {
            while (reader.ready() == true){
                builder.append(reader.readLine());
                builder.append(" ");
            }
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

        String s = builder.toString();

        String[] strings = s.split(" ");

        for (int i1 = 0; i1 < strings.length; i1++){
            if(strings[i1] != null){
                String s1 = new StringBuilder(strings[i1]).reverse().toString();

                for (int i2 = i1+1; i2 < strings.length; i2++){
                    if(s1.equals(strings[i2])){
                        Pair pair = new Pair();
                        pair.first = strings[i1];
                        pair.second = s1;
                        result.add(pair);
                        strings[i2] = null;
                        break;
                    }
                }
            }
        }

        for (Pair pair : result){
            System.out.println(pair.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

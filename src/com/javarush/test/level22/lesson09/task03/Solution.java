package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        //...
        String s = "";

        try(BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new FileReader(reader1.readLine())))
        {
            while (reader2.ready()){
                s += reader2.readLine();
                if (reader2.ready()){
                    s += " ";
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String[] words = s.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder builder = new StringBuilder();

        if (words.length == 0 || words == null){
            return builder;
        }

        List<String> listOriginal = new ArrayList<>();

        Collections.addAll(listOriginal, words);

        Collections.sort(listOriginal);

        List<String> list = new ArrayList<>(listOriginal);

        while (list.size() != 0){

            if (builder.length() == 0){
                builder.append(list.get(0));
                list.remove(0);
            }

            int control = -1;

            for (int i = 0; i < list.size(); i++){
                if(Character.toLowerCase(builder.charAt(0)) == Character.toLowerCase(list.get(i).charAt(list.get(i).length()-1))){
                    builder.insert(0, list.get(i) + " ");
                    control = i;
                    break;
                }
                else if (Character.toLowerCase(builder.charAt(builder.length()-1)) == Character.toLowerCase(list.get(i).charAt(0))){
                    builder.append(" " + list.get(i));
                    control = i;
                    break;
                }
            }

            if (control != -1){
                list.remove(control);
            }
            else if (control == -1 && list.size() != 0){
                builder.setLength(0);

                for (int i = 0; i < listOriginal.size()-1; i++){
                    if (Character.toLowerCase(listOriginal.get(i).charAt(0)) == Character.toLowerCase(listOriginal.get(i+1).charAt(0))){
                        listOriginal.add(listOriginal.get(i));
                        listOriginal.remove(i);
                        break;
                    }
                    else if (Character.toLowerCase(listOriginal.get(i).charAt(listOriginal.get(i).length()-1)) == Character.toLowerCase(listOriginal.get(i+1).charAt(listOriginal.get(i+1).length()-1))){
                        listOriginal.add(listOriginal.get(i));
                        listOriginal.remove(i);
                        break;
                    }
                }

                list = new ArrayList<>(listOriginal);
            }
        }

        return builder;
    }
}

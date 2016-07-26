package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));

        List<String> list = new ArrayList<>();

        String s = "";

        while ((s = reader1.readLine()) != null){
            list.add(s);
        }

        reader1.close();

        if (args[0].equals("-u")){

            String id = addSpaces(args[1], 8);

            String productName = addSpaces(args[2], 30);

            String price = addSpaces(args[3], 8);

            String quantity = addSpaces(args[4], 4);

            int a = 0;

            for (int i = 0; i < list.size(); i++){
                if (list.get(i).substring(0, 8).equals(id)){
                    list.set(i, id + productName + price + quantity);
                    break;
                }
            }
        }
        else if (args[0].equals("-d")){

            String id = addSpaces(args[1], 8);

            for (int i = 0; i < list.size(); i++){
                if (list.get(i).substring(0, 8).equals(id)){
                    list.remove(i);
                    break;
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < list.size(); i++){
                writer.write(list.get(i));
                writer.newLine();
        }

        writer.close();
    }

    private static String addSpaces (String s, int space){
        if (s.length() < space){
            for (int i = s.length(); i < space; i++){
                s += " ";
            }

            return s;
        }

        else return s;
    }
}

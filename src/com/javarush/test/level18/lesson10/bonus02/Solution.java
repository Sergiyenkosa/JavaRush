package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();



        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));

        String s = "";
        int id = 0;

        while ((s = reader1.readLine()) != null){
            String idBuffer = "";
            for(int i = 0; i < 8; i++){
                if (s.charAt(i) != ' '){
                    idBuffer += s.charAt(i);
                }
                else {
                    break;
                }
            }

            if(Integer.parseInt(idBuffer) > id){
                id = Integer.parseInt(idBuffer);
            }
        }

        reader1.close();

        id = id + 1;

        s = String.valueOf(id);

        if (s.length() != 8){
            for(int i = s.length(); i < 8; i++){
                s = s + " ";
            }
        }

        String productName = args[1];

        if(productName.length()<30){
            for(int i = productName.length(); i < 30; i++){
                productName = productName + " ";
            }
        }

        String price = args[2];

        if (price.length() != 8){
            for(int i = price.length(); i < 8; i++){
                price = price + " ";
            }
        }

        String quantity = args[3];
        if (quantity.length() != 4){
            for(int i = quantity.length(); i < 4; i++){
                quantity = quantity + " ";
            }
        }

        String result = s + productName + price + quantity;

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(result.toCharArray());
        writer.newLine();
        writer.close();
    }
}

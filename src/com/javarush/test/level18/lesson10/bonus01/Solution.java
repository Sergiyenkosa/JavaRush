package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 0){
            return;
        }

        if (args[0].equals("-e")){
            FileInputStream in = new FileInputStream(args[1]);
            FileOutputStream out = new FileOutputStream(args[2]);

            while (in.available() > 0){
                out.write(in.read() + 1);
            }

            out.close();
            in.close();
        }

        else if (args[0].equals("-d")){
            FileInputStream in = new FileInputStream(args[1]);
            FileOutputStream out= new FileOutputStream(args[2]);

            while (in.available() > 0){
                out.write(in.read() - 1);
            }

            out.close();
            in.close();
        }
    }

}

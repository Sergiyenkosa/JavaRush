package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        while (reader.ready()){
            String line = reader.readLine();
            String[] strings = line.split(" ");

            for(int i = 0; i < strings.length; i++){
                Pattern p = Pattern.compile(".+[0-9].+");
                Matcher m = p.matcher(strings[i]);

                if (m.matches() == true){
                    writer.write(strings[i]);
                    if (reader.ready()!=false && i != strings.length){
                        writer.write(" ");
                    }
                }
            }
        }

        writer.close();
        reader.close();
    }
}

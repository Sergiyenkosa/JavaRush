package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        Map<Integer, String> filesMap = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = "";
        String fileNameCopy = "";

        while (!(fileName = reader.readLine()).equals("end")){
            String number = "";
            fileNameCopy = fileName;
            for (int i = fileName.length() - 1; i > 0; i--){
                if (fileName.charAt(i) != 't')
                number = fileName.charAt(i) + number;
                else {
                    break;
                }
            }

            filesMap.put(Integer.parseInt(number), fileName);
        }

        reader.close();

        for (int i = fileNameCopy.length()-1; i >= 0; i--){
            if (fileNameCopy.charAt(i) == '.'){
                fileName = fileNameCopy.substring(0, i);
                break;
            }
        }

        FileOutputStream out = new FileOutputStream(fileName);

        for (Map.Entry<Integer, String> entry : filesMap.entrySet()){
            FileInputStream in = new FileInputStream(entry.getValue());

            while (in.available() > 0){
                out.write(in.read());
            }

            out.flush();
            in.close();
        }

        out.close();
    }
}

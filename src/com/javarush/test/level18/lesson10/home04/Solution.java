package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        FileInputStream in1 = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);

        int i1 = in1.available();

        byte[] i = new byte[i1];

        int count = in1.read(i, 0, i1);

        in1.close();

        FileOutputStream out = new FileOutputStream(file1);

        while (in2.available() > 0){
            out.write(in2.read());
        }

        out.flush();

        out.write(i);

        out.close();

        in2.close();
    }
}

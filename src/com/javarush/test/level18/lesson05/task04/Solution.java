package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
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

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);

        byte[] b = new byte[inputStream.available()];

        int count = inputStream.read(b);

        for (int i = 0; i < b.length/2; i++){
            byte a = b[i];
            b[i] = b[b.length-i-1];
            b[b.length-i-1] = a;
        }

        outputStream.write(b, 0, count);

        inputStream.close();
        outputStream.close();
    }
}

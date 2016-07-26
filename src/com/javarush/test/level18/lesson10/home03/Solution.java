package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        reader.close();

        FileInputStream in1 = new FileInputStream(file2);
        FileInputStream in2 = new FileInputStream(file3);
        FileOutputStream out = new FileOutputStream(file1);

        while (in1.available() > 0){
            out.write(in1.read());
        }

        out.flush();

        while (in2.available() > 0){
            out.write(in2.read());
        }

        in1.close();
        in2.close();
        out.close();
    }
}

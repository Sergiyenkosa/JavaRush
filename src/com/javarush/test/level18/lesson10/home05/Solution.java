package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);

        String s = "";

        while (in.available() > 0){
            Character c = (char) in.read();
            if (!c.equals(' ')){
                s += c;
            }

            else if (c.equals(' ')){
                if(s.startsWith("-")){
                    String a = (new BigDecimal(s).setScale(0, BigDecimal.ROUND_HALF_DOWN).toString()) + " ";
                    out.write(a.getBytes());
                    s = "";
                }

                else {
                    String a = (new BigDecimal(s).setScale(0, BigDecimal.ROUND_HALF_UP).toString()) + " ";
                    out.write(a.getBytes());
                    s = "";
                }
            }

            if (in.available() == 0){
                if(s.startsWith("-")){
                    String a = (new BigDecimal(s).setScale(0, BigDecimal.ROUND_HALF_DOWN).toString());
                    out.write(a.getBytes());
                    s = "";
                }

                else {
                    String a = (new BigDecimal(s).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
                    out.write(a.getBytes());
                    s = "";
                }
            }

        }

        in.close();
        out.close();
    }
}

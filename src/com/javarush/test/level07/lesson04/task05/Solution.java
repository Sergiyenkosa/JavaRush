package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        int[] numbers = new int[20];
        int[] n1 = new int[10];
        int[] n2 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int a = 0; a < numbers.length; a++)
            numbers[a] = Integer.parseInt(reader.readLine());

        for (int a = 0; a < n1.length; a++){
            n1[a] = numbers[a];
            n2[a] = numbers[a+10];
        }

        for (int a = 0; a < n2.length; a++)
            System.out.println(n2[a]);

    }
}

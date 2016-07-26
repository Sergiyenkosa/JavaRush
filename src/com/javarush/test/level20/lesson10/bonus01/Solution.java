package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static int[] getNumbers(int N) {

        /*for (int i = 1; i < N; i++){
            String s = String.valueOf(i);

            long l = 0;

            int[] ints = new int[s.length()];

            for (int i1 = 0; i1 < ints.length; i1++){
                ints[i1] = Character.getNumericValue(s.charAt(i1));
            }

            for (int i1 = 0; i1 < ints.length; i1++){

                long a = ints[i1];

                for(int i2 = 1; i2 < ints.length; i2++){
                    a *= ints[i1];
                }

                l += a;
            }

            if (i == l){
                list.add(i);
            }
        }

        int[] a = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            a[i] = list.get(i);
        }*/

        String s = "1 2 3 4 5 6 7 8 9 153 370 371 407 1634 8208 9474 54748 92727 93084 548834 1741725 4210818 9800817 9926315 24678050 24678051 88593477 146511208 472335975 534494836 912985153";

        String[] strings = s.split(" ");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++){
            if (Integer.parseInt(strings[i]) < N){
                list.add(Integer.parseInt(strings[i]));
            }
        }

        int[] ints = new int[list.size()];

        for(int i = 0; i < list.size(); i ++){
            ints[i] = list.get(i);
        }

        int[] result = ints;
        return result;
    }
}

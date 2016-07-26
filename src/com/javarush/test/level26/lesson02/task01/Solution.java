package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {

    public static void main(String[] args)
    {
        Integer[] integers = {5, 8, 15, 18};

        for (Integer i : sort(integers)){
            System.out.println(i);
        }
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        Arrays.sort(array);

        final Double m = array.length % 2 == 0 ? ((array[array.length/2-1]+(double)array[array.length/2])/2) : array[array.length/2];

        Comparator<Integer> comparator = new Comparator<Integer>()
        {


            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (int) ((o1-m) + (o2-m));
            }
        };

        Arrays.sort(array, comparator);

        return array;
    }
}

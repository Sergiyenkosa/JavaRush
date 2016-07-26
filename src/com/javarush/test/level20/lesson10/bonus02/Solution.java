package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {

        for (int i1 = 0; i1 < a.length; i1++){
            for(int i2 = 0; i2 < a[0].length-1; i2++){
                if(a[i1][i2] == 1 && a[i1][i2+1] == 1){
                    a[i1][i2] = 0;
                }
            }
        }

        for (int i1 = 0; i1 < a[0].length; i1++){
            for(int i2 = 0; i2 < a.length-1; i2++){
                if(a[i2][i1] == 1 && a[i2+1][i1] == 1){
                    a[i2][i1] = 0;
                }
            }
        }

        int count = 0;

        for (int i1 = 0; i1 < a.length; i1++){
            for(int i2 = 0; i2 < a[0].length; i2++){
                if(a[i1][i2] == 1){
                    count +=1;
                }
            }
        }
        return count;
    }
}

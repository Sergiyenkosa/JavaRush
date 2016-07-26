package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();

        for(String s : words){

            for(int i1 = 0; i1 < crossword.length; i1++){

                List<Integer> X = new ArrayList<>();
                List<Integer> Y = new ArrayList<>();
                String text = "";

                for(int i2 = 0; i2 < crossword[i1].length; i2++){
                    text += (char)crossword[i1][i2];
                    Y.add(i1);
                    X.add(i2);
                }

                StringBuilder builder = new StringBuilder(text);
                int wordFirst1 = builder.indexOf(s);
                int wordLast1 = wordFirst1 + s.length()-1;

                if(wordFirst1 > -1){
                    Word word = new Word(s);
                    word.setStartPoint(X.get(wordFirst1), Y.get(wordFirst1));
                    word.setEndPoint(X.get(wordLast1), Y.get(wordLast1));

                    list.add(word);
                }

                builder = builder.reverse();
                Collections.reverse(X);
                Collections.reverse(Y);

                int wordFirst2 = builder.indexOf(s);
                int wordLast2 = wordFirst2 + s.length()-1;

                if(wordFirst2 > -1){
                    Word word = new Word(s);
                    word.setStartPoint(X.get(wordFirst2), Y.get(wordFirst2));
                    word.setEndPoint(X.get(wordLast2), Y.get(wordLast2));

                    list.add(word);
                }
            }

            for(int i1 = 0; i1 < crossword[0].length; i1++){

                List<Integer> X = new ArrayList<>();
                List<Integer> Y = new ArrayList<>();
                String text = "";

                for(int i2 = 0; i2 < crossword.length; i2++){
                    text += (char)crossword[i2][i1];
                    Y.add(i2);
                    X.add(i1);
                }

                StringBuilder builder = new StringBuilder(text);
                int wordFirst1 = builder.indexOf(s);
                int wordLast1 = wordFirst1 + s.length()-1;

                if(wordFirst1 > -1){
                    Word word = new Word(s);
                    word.setStartPoint(X.get(wordFirst1), Y.get(wordFirst1));
                    word.setEndPoint(X.get(wordLast1), Y.get(wordLast1));

                    list.add(word);
                }

                builder = builder.reverse();
                Collections.reverse(X);
                Collections.reverse(Y);

                int wordFirst2 = builder.indexOf(s);
                int wordLast2 = wordFirst2 + s.length()-1;

                if(wordFirst2 > -1){
                    Word word = new Word(s);
                    word.setStartPoint(X.get(wordFirst2), Y.get(wordFirst2));
                    word.setEndPoint(X.get(wordLast2), Y.get(wordLast2));

                    list.add(word);
                }
            }

            int i2 = 0;

            for (int i1 = 0; i1 < crossword.length; i1++){

                List<Integer> X = new ArrayList<>();
                List<Integer> Y = new ArrayList<>();
                String text = "";

                for (; i2 < crossword[0].length-1; i2++){

                    int a1 = i1;
                    int a2 = i2;


                    while (true){
                        if (a1 > crossword.length-1 || a2 < 0){
                            break;
                        }

                        text += (char)crossword[a1][a2];

                        Y.add(a1);
                        X.add(a2);

                        a1 += 1;
                        a2 -= 1;
                    }

                    StringBuilder builder = new StringBuilder(text);
                    int wordFirst1 = builder.indexOf(s);
                    int wordLast1 = wordFirst1 + s.length()-1;

                    if(wordFirst1 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst1), Y.get(wordFirst1));
                        word.setEndPoint(X.get(wordLast1), Y.get(wordLast1));

                        list.add(word);
                    }

                    builder = builder.reverse();
                    Collections.reverse(X);
                    Collections.reverse(Y);

                    int wordFirst2 = builder.indexOf(s);
                    int wordLast2 = wordFirst2 + s.length()-1;

                    if(wordFirst2 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst2), Y.get(wordFirst2));
                        word.setEndPoint(X.get(wordLast2), Y.get(wordLast2));

                        list.add(word);
                    }

                    X.clear();
                    Y.clear();

                    text = "";
                }

                if(i2 == crossword[0].length-1){
                    int a1 = i1;
                    int a2 = i2;

                    while (true){
                        if (a1 > crossword.length-1 || a2 < 0){
                            break;
                        }

                        text += (char)crossword[a1][a2];

                        Y.add(a1);
                        X.add(a2);

                        a1 += 1;
                        a2 -= 1;
                    }

                    StringBuilder builder = new StringBuilder(text);
                    int wordFirst1 = builder.indexOf(s);
                    int wordLast1 = wordFirst1 + s.length()-1;

                    if(wordFirst1 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst1), Y.get(wordFirst1));
                        word.setEndPoint(X.get(wordLast1), Y.get(wordLast1));

                        list.add(word);
                    }

                    builder = builder.reverse();
                    Collections.reverse(X);
                    Collections.reverse(Y);

                    int wordFirst2 = builder.indexOf(s);
                    int wordLast2 = wordFirst2 + s.length()-1;

                    if(wordFirst2 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst2), Y.get(wordFirst2));
                        word.setEndPoint(X.get(wordLast2), Y.get(wordLast2));

                        list.add(word);
                    }

                    X.clear();
                    Y.clear();
                }
            }

            i2 = 0;

            for (int i1 = crossword.length-1; i1 > -1; i1--){

                List<Integer> X = new ArrayList<>();
                List<Integer> Y = new ArrayList<>();
                String text = "";

                for (; i2 < crossword[0].length-1; i2++){

                    int a1 = i1;
                    int a2 = i2;


                    while (true){
                        if (a1 < 0 || a2 < 0){
                            break;
                        }

                        text += (char)crossword[a1][a2];

                        Y.add(a1);
                        X.add(a2);

                        a1 -= 1;
                        a2 -= 1;
                    }

                    StringBuilder builder = new StringBuilder(text);
                    int wordFirst1 = builder.indexOf(s);
                    int wordLast1 = wordFirst1 + s.length()-1;

                    if(wordFirst1 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst1), Y.get(wordFirst1));
                        word.setEndPoint(X.get(wordLast1), Y.get(wordLast1));

                        list.add(word);
                    }

                    builder = builder.reverse();
                    Collections.reverse(X);
                    Collections.reverse(Y);

                    int wordFirst2 = builder.indexOf(s);
                    int wordLast2 = wordFirst2 + s.length()-1;

                    if(wordFirst2 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst2), Y.get(wordFirst2));
                        word.setEndPoint(X.get(wordLast2), Y.get(wordLast2));

                        list.add(word);
                    }

                    X.clear();
                    Y.clear();

                    text = "";
                }

                if(i2 == crossword[0].length-1){
                    int a1 = i1;
                    int a2 = i2;

                    while (true){
                        if (a1 < 0 || a2 < 0){
                            break;
                        }

                        text += (char)crossword[a1][a2];

                        Y.add(a1);
                        X.add(a2);

                        a1 -= 1;
                        a2 -= 1;
                    }

                    StringBuilder builder = new StringBuilder(text);
                    int wordFirst1 = builder.indexOf(s);
                    int wordLast1 = wordFirst1 + s.length()-1;

                    if(wordFirst1 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst1), Y.get(wordFirst1));
                        word.setEndPoint(X.get(wordLast1), Y.get(wordLast1));

                        list.add(word);
                    }

                    builder = builder.reverse();
                    Collections.reverse(X);
                    Collections.reverse(Y);

                    int wordFirst2 = builder.indexOf(s);
                    int wordLast2 = wordFirst2 + s.length()-1;

                    if(wordFirst2 > -1){
                        Word word = new Word(s);
                        word.setStartPoint(X.get(wordFirst2), Y.get(wordFirst2));
                        word.setEndPoint(X.get(wordLast2), Y.get(wordLast2));

                        list.add(word);
                    }

                    X.clear();
                    Y.clear();
                }
            }
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

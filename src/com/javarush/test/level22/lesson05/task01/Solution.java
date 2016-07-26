package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString(" "));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {

        int space = 0;
        if (string == null){
            throw new TooShortStringException();
        }
        if ((space = string.indexOf(' ')) == -1){
            throw new TooShortStringException();
        }
        for (int i = 0; i < 3; i++){
            if ((space = string.indexOf(' ', space+1)) == -1){
                throw new TooShortStringException();
            }
        }

        int begin = string.indexOf(' ') + 1;

        int gaps = begin;

        for (int i = 0; i < 3; i++){
            gaps = string.indexOf(' ', gaps) + 1;
        }

        int and = 0;

        for (int i = gaps; i < string.length(); i++){
            if (Character.isAlphabetic(string.charAt(i))){
                and = i;
            }
            else {
                break;
            }
        }

        and += 1;

        return string.substring(begin, and);
    }

    public static class TooShortStringException extends Exception
    {
    }
}

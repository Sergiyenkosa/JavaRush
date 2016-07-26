package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import javax.xml.transform.Result;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        String[] s = result.split(" ");

        int i1 = Integer.parseInt(s[0]);

        int i2 = Integer.parseInt(s[2]);

        if(s[1].equals("+")){
            result = i1 +  " + " + i2 + " = " + (i1 + i2);
        }
        else if(s[1].equals("-")){
            result = i1 + " - " + i2 + " = " + (i1 - i2);
        }
        else if(s[1].equals("*")){
            result = i1 + " * " + i2 + " = " + (i1 * i2);
        }

        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


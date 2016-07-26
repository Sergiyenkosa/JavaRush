package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution (){

    }

    public Solution (String a, String b){

    }

    public Solution(String a, String b, String d){

    }

    Solution(Integer a){

    }

    Solution(Integer a, Integer b){

    }

    Solution(Integer a, Integer b, Integer d){

    }

    protected Solution(Boolean a){

    }

    protected Solution(Boolean a, Boolean b){

    }

    protected Solution(Boolean a, Boolean b, Boolean d){

    }

    private Solution(Long a){

    }

    private Solution(Long a, Long b){

    }

    private Solution(Long a, Long b, Long d){

    }
}


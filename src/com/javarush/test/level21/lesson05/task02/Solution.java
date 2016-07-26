package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o==null)
            return false;

        if (o.getClass() != this.getClass() )
            return false;

        Solution n = (Solution) o;

        if (n.first != null && n.last!=null && first != null && last!=null){
            return n.first.equals(first) && n.last.equals(last);
        }
        else if (n.first != null && first != null){
            return n.first.equals(first);
        }
        else if (n.last!=null && last!=null){
            return n.last.equals(last);
        }
        else if (n.first == null && n.last==null && first == null && last==null){
            return true;
        }
        else {
            return false;
        }
    }

    public int hashCode()
    {
        if (this.first != null && this.last != null){
            return 31 * first.hashCode() + last.hashCode();
        }

        else if (this.first != null){
            return 31 * first.hashCode();
        }

        else if (this.last != null){
            return 31 * last.hashCode();
        }

        else return 31;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));

        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}

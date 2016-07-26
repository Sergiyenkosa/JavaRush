package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    public static void main(String[] args)
    {
        Date date = new Date();

        Solution s0 = new Solution(0,"a", 1, date, null);

        Solution s1 = new Solution(0,"a", 0, date, s0);

        Solution s2 = new Solution(0,"a", 0, date, s0);

        System.out.println(s1.hashCode() + " " + s2.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (string != null ? string.hashCode() : 0);

        return result;
    }
}

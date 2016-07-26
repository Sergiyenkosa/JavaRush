package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj==null)
            return false;

        if (obj.getClass() != this.getClass() )
            return false;

        Solution n = (Solution) obj;

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

    @Override
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
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, null)));

        Solution s1 = new Solution(null, null);
        Solution s2 = new Solution(null, null);

        System.out.println(s1.hashCode() + " " + s2.hashCode());
    }
}

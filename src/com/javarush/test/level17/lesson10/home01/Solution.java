package com.javarush.test.level17.lesson10.home01;

import java.util.*;

/* Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution implements List<Long>{
    private volatile ArrayList<Long> original = new ArrayList<Long>();

    @Override
    public int size()
    {
        synchronized (Solution.class){
            return original.size();
        }
    }

    @Override
    public boolean isEmpty()
    {
        synchronized (Solution.class){
            return original.isEmpty();
        }
    }

    @Override
    public boolean contains(Object o)
    {
        synchronized (Solution.class){
            return original.contains(o);
        }
    }

    @Override
    public Iterator<Long> iterator()
    {
        synchronized (Solution.class){
            return original.iterator();
        }
    }

    @Override
    public Object[] toArray()
    {
        synchronized (Solution.class){
            return original.toArray();
        }
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        synchronized (Solution.class){
            return original.toArray(a);
        }
    }

    @Override
    public boolean add(Long aLong)
    {
        synchronized (Solution.class){
            return original.add(aLong);
        }
    }

    @Override
    public boolean remove(Object o)
    {
        synchronized (Solution.class){
            return original.remove(o);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        synchronized (Solution.class){
            return original.containsAll(c);
        }
    }

    @Override
    public boolean addAll(Collection<? extends Long> c)
    {
        synchronized (Solution.class){
            return original.addAll(c);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends Long> c)
    {
        synchronized (Solution.class){
            return original.addAll(index, c);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        synchronized (Solution.class){
            return original.removeAll(c);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        synchronized (Solution.class){
            return original.retainAll(c);
        }
    }

    @Override
    public void clear()
    {
        synchronized (Solution.class){
            original.clear();
        }
    }

    @Override
    public Long get(int index)
    {
        synchronized (Solution.class){
            return original.get(index);
        }
    }

    @Override
    public Long set(int index, Long element)
    {
        synchronized (Solution.class){
            return original.set(index, element);
        }
    }

    @Override
    public void add(int index, Long element)
    {
        synchronized (Solution.class){
            original.add(index, element);
        }
    }

    @Override
    public Long remove(int index)
    {
        synchronized (Solution.class){
            return original.remove(index);
        }
    }

    @Override
    public int indexOf(Object o)
    {
        synchronized (Solution.class){
            return original.indexOf(o);
        }
    }

    @Override
    public int lastIndexOf(Object o)
    {
        synchronized (Solution.class){
            return original.lastIndexOf(o);
        }
    }

    @Override
    public ListIterator<Long> listIterator()
    {
        synchronized (Solution.class){
            return original.listIterator();
        }
    }

    @Override
    public ListIterator<Long> listIterator(int index)
    {
        synchronized (Solution.class){
            return original.listIterator(index);
        }
    }

    @Override
    public List<Long> subList(int fromIndex, int toIndex)
    {
        synchronized (Solution.class){
            return original.subList(fromIndex,toIndex);
        }
    }
}

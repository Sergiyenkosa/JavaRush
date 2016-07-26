package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;
import java.util.List;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{

    private List<Node> list0 = new ArrayList<>();

    private Node<String> root = new Node<>(null, null);

    public static void main(String[] args)
    {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        list.remove("2");
        list.remove("9");

        for(int i = 16; i < 21; i++){
            list.add(String.valueOf(i));
        }

        list.remove("18");
        list.remove("19");

        list.add("21");
        list.add("22");

        for (String s : list){
            System.out.println(s + " " + ((Solution)list).getParent(s));
        }

        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));

        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));

        /*
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\s.sergiyenko\\Desktop\\Новый текстовый документ (2).abv")))
        {
            outputStream.writeObject(list);
            outputStream.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\s.sergiyenko\\Desktop\\Новый текстовый документ (2).abv")))
        {
            list = (List<String>) inputStream.readObject();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        */
    }

    private static class Node<E> implements Serializable{
        E item;
        Node<E> previous;
        Node<E> nextLeft;
        Node<E> nextRight;

        Node(E element, Node<E> previous) {
            this.item = element;
            this.previous = previous;
        }
    }

    protected Solution()
    {
        super();
    }


    private void UnsupportedOperationException(){
        throw new UnsupportedOperationException();
    }

    public Solution clone() throws CloneNotSupportedException {
        Solution clone = (Solution)super.clone();
        return clone;
    }

    public String getParent(String value) {
        //have to be implemented
        String s = null;

        if (root.nextLeft != null){
            if (value.equals(root.nextLeft.item)){
                return null;
            }
        }

        if (root.nextRight != null){
            if (value.equals(root.nextRight.item)){
                return null;
            }
        }

        for (Node node : list0){
            if (node.item.equals(value)){
                s = node.previous.item.toString();
            }
        }

        return s;
    }

    @Override
    public boolean remove(Object o)
    {
        if(!list0.isEmpty()){

            for (Node n : list0){
                if (n.item.equals(o)){

                    if (n.previous.nextLeft == n){
                        n.previous.nextLeft = null;
                    }
                    else {
                        n.previous.nextRight = null;
                    }

                    n.previous = null;
                }
            }
        }

        List<Node> list1 = new LinkedList<>();

        for (Node n : list0){

            Node node = n.previous;

            while (true){
                if(node == null) break;
                if (node == root){
                    list1.add(n);
                    break;
                }

                node = node.previous;
            }
        }

        list0 = list1;

        return true;
    }

    @Override
    public boolean add(String s)
    {

        if (list0.isEmpty()){

            Node n = new Node(s, root);

            root.nextLeft = n;

            list0.add(n);
        }
        else {

            if (list0.get(list0.size()-1).previous.nextRight == null){
                Node n = new Node(s, list0.get(list0.size()-1).previous);
                list0.get(list0.size()-1).previous.nextRight = n;
                list0.add(n);
            }
            else if (list0.get(list0.size()-1).previous.nextLeft == null){
                list0.get(list0.size()-1).previous.nextLeft = list0.get(list0.size()-1).previous.nextRight;

                Node n = new Node(s, list0.get(list0.size()-1).previous);
                list0.get(list0.size()-1).previous.nextRight = n;
                list0.add(n);
            }
            else {

                Node n = new Node(null, null);

                if (list0.get(list0.size()-1).previous == root){
                    n = new Node(s, root.nextLeft);
                    root.nextLeft.nextLeft = n;
                }
                else {
                    for (int i = 0; i < list0.size(); i++){

                        if (list0.get(i) == list0.get(list0.size()-1).previous){
                            n = new Node(s, list0.get(i+1));
                            list0.get(i+1).nextLeft = n;
                        }
                    }
                }

                if (n.previous != null){
                    list0.add(n);
                }
            }
        }
        return true;
    }

    @Override
    public Iterator<String> iterator()
    {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < list0.size(); i++){
            list.add((String) list0.get(i).item);
        }

        return list.iterator();
    }

    @Override
    public String get(int index)
    {
        UnsupportedOperationException();
        return null;
    }

    @Override
    public int size()
    {
        return list0.size();
    }

    @Override
    public void add(int index, String element)
    {
        UnsupportedOperationException();
        super.add(index, element);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        UnsupportedOperationException();
        return super.addAll(index, c);
    }

    @Override
    public void clear()
    {
        root = null;
        list0.clear();
    }

    @Override
    public boolean equals(Object o)
    {
        return this.equals(o);
    }

    @Override
    public int hashCode()
    {
        return this.hashCode();
    }

    @Override
    public int indexOf(Object o)
    {
        UnsupportedOperationException();
        return super.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        UnsupportedOperationException();
        return super.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator()
    {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < list0.size(); i++){
            list.add((String) list0.get(i).item);
        }

        return list.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index)
    {
        UnsupportedOperationException();
        return super.listIterator(index);
    }

    @Override
    public String remove(int index)
    {
        UnsupportedOperationException();
        return super.remove(index);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex)
    {
        UnsupportedOperationException();
        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public String set(int index, String element)
    {
        UnsupportedOperationException();
        return super.set(index, element);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        UnsupportedOperationException();
        return super.subList(fromIndex, toIndex);
    }
}

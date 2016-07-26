package com.javarush.test.level14.lesson08.bonus01;

import org.omg.CORBA.INITIALIZE;
import org.omg.IOP.ExceptionDetailMessage;

import javax.annotation.Generated;
import java.beans.ExceptionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            Integer.parseInt("a");
        }
        catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            List l = new ArrayList();
            for (int i = 0; i <10; i++)
                l.get(i);
        }
        catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            Object o = new Object();
            Solution s = (Solution) new Object();
        }
        catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new EmptyStackException();
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try
        {
            throw new EOFException();
        }
        catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new IllegalMonitorStateException();
        }
        catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new InstantiationException();
        }
        catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new UnsupportedOperationException();
        }
        catch (Exception e){
            exceptions.add(e);
        }

        try
        {
            throw new StringIndexOutOfBoundsException();
        }
        catch (Exception e){
            exceptions.add(e);
        }
    }
}

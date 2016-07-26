package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    private static Properties proper = new Properties();

    public static void main(String[] args) throws Exception
    {
        new Solution().fillInPropertiesMap();

        OutputStream out = new FileOutputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv");

        new Solution().save(out);

        out.close();
    }

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream in = new FileInputStream(reader.readLine());

        reader.close();

        load(in);

        in.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

        if (proper.size() > 0)
            proper.putAll(properties);
        proper.store(outputStream, "");

        outputStream.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        proper.load(inputStream);

        for (Map.Entry<Object, Object> entry : proper.entrySet()){
            properties.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}

package com.javarush.test.level20.lesson04.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Human human = new Human("gsdfgsdfg", new Asset("gegdfg"), new Asset("gdsf"), new Asset("gsdg"));

        FileOutputStream out = new FileOutputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv");
        ObjectOutputStream oOut = new ObjectOutputStream(out);
        oOut.writeObject(human);
        out.close();
        oOut.close();

        Human human1 = new Human();

        FileInputStream in = new FileInputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv");
        ObjectInputStream iIn = new ObjectInputStream(in);
        Object object = iIn.readObject();
        in.close();
        iIn.close();

        human1 = (Human) object;
    }

    public static class Human implements Serializable{
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }
}

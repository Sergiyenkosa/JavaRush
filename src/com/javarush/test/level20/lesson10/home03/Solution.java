package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution s = new Solution();

        Solution.B b = s.new B("fgsdg");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv"));

        outputStream.writeObject(b);

        outputStream.flush();

        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv"));

        System.out.println(b.name);

        b = (B) inputStream.readObject();

        inputStream.close();

        System.out.println(b.name);
    }

    public static class A {
        protected A(){
        }

        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream stream)
                throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(name);
        }
        private void readObject(ObjectInputStream stream)
                throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            name = (String)stream.readObject();
        }
    }
}

package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution{

    public static class Person implements Serializable{

        public static void main(String[] args) throws IOException, ClassNotFoundException
        {
            Person person1 = new Person("A", "B", "C", Sex.MALE);

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv"));

            outputStream.writeObject(person1);

            outputStream.flush();

            outputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv"));

            Person person2 = (Person) inputStream.readObject();

            inputStream.close();

            System.out.println(person2.fullName);
        }

        String firstName;
        String lastName;
        transient String fullName;
        final transient String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}

package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        public String firstName;
        public String lastName;
        public boolean sex;
        public int height;
        public int weight;
        public String cityBorn;

        public Human (String firstName){
            this.firstName = firstName;
        }

        public Human (String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human (String firstName, String lastName, boolean sex){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human (String firstName, String lastName, boolean sex, int height){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.height = height;
        }

        public Human (String firstName, String lastName, boolean sex, int height, int weight){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }

        public Human (String firstName, String lastName, boolean sex, int height, int weight, String cityBorn){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.cityBorn = cityBorn;
        }

        public Human (String firstName, boolean sex, int height, int weight, String cityBorn){
            this.firstName = firstName;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.cityBorn = cityBorn;
        }

        public  Human (String firstName, String lastName, int height, int weight, String cityBorn){
            this.firstName = firstName;
            this.lastName = lastName;
            this.height = height;
            this.weight = weight;
            this.cityBorn = cityBorn;
        }

        public Human (String firstName, String lastName, boolean sex, int height, String cityBorn){
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.height = height;
            this.cityBorn = cityBorn;
        }

        public Human (String firstName, boolean sex, int height, String cityBorn){
            this.firstName = firstName;
            this.sex = sex;
            this.height = height;
            this.cityBorn = cityBorn;
        }


    }
}

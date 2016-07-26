package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Objects;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human doter = new Human("Lina", false, 25);
        Human son1 = new Human("Vladimir", true, 23);
        Human son2 = new Human("Roman", true, 18);
        Human father = new Human("Igor", true, 41, doter, son1, son2);
        Human mother = new Human("Lena", false, 41, doter, son1, son2);
        Human grandFather1 = new Human("Valera", true, 60, father);
        Human grandFather2 = new Human("Ivan", true, 60, mother);
        Human grandMother1 = new Human("Lesya", false, 50, father);
        Human grandMother2 = new Human("Vita", false, 48, mother);

        System.out.println(grandFather1.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(doter.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
    }

    public static class Human
    {
        //напишите тут ваш код

        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(children);
        }

        public Human(String name, boolean sex, int age, Human children1, Human children2){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(children1);
            this.children.add(children2);
        }

        public Human(String name, boolean sex, int age, Human children1, Human children2, Human children3){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(children1);
            this.children.add(children2);
            this.children.add(children3);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

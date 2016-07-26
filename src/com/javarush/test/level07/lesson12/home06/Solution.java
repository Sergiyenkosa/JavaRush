package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код

        Human gf1 = new Human("Мища", true, 50);
        Human gf2 = new Human("Павел", true, 50);
        Human gm1 = new Human("Лера", false, 45);
        Human gm2 = new Human("Катя", false, 55);
        Human f = new Human("Михаил", true, 25, gf1, gm1);
        Human m = new  Human("Катя", false, 21, gf2, gm2);
        Human d1 = new Human("Лена" , false, 3, f, m);
        Human s1 = new Human("Игорь" , true, 2, f, m);
        Human d2 = new Human("Маша", false, 1, f, m);

        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(d1);
        System.out.println(s1);
        System.out.println(d2);

    }

    public static class Human
    {
        //напишите тут ваш код

        String name;
        Boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, Boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, Boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}

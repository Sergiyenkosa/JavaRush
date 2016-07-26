package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код

        Mouse pekosMouse = new Mouse("Pekos", 10, 3);

        Cat tomCat = new Cat("Tom", 30, 7);

        Cat butchCat = new Cat("Butch", 35, 5);

        Dog spikeDog = new Dog("Spike", 50, 10);

        Dog tikeDog = new Dog("Tike", 20, 1);


    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы

    public static class Cat{
        String name;
        int height;
        int whiskers;

        public Cat(String name, int height, int whiskers){
            this.name = name;
            this.height = height;
            this.whiskers = whiskers;
        }

    }

    public static class Dog{
        String name;
        int height;
        int strong;

        public Dog(String name, int height, int strong){
            this.name = name;
            this.height = height;
            this.strong = strong;
        }
    }

}

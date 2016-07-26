package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by s.sergienko on 06.04.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {

        game = new Hippodrome();

        game.getHorses().add(new Horse("Lama", 3, 0));
        game.getHorses().add(new Horse("Bagira", 3, 0));
        game.getHorses().add(new Horse("Tina", 3, 0));

        game.run();

        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).move();
        }
    }

    public void print(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner(){
        int horse = 0;

        for (int i = 0; i < horses.size(); i++){
            if (horses.get(i).getDistance() > horses.get(horse).getDistance()){
                horse = i;
            }
        }

        return horses.get(horse);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}

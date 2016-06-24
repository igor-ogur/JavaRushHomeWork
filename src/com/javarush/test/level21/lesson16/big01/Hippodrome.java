package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by SKLAD-PC on 27.10.15.
 */
public class Hippodrome {
    static ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public static void main(String[] args) {
        game = new Hippodrome();

        horses.add(new Horse("Hurricane", 3, 0));
        horses.add(new Horse("Zephyr", 3, 0));
        horses.add(new Horse("Fearless", 3, 0));

        game.getHorses();

        game.run();

        game.printWinner();
    }

    public void move (){
        for (Horse horse : horses){
            horse.move();
        }
    }
    public void print (){
        for (Horse horse : horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }
    public void run () {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner (){
        double maxD = 0d;
        int number = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (maxD < horses.get(i).getDistance()) {
                maxD = horses.get(i).getDistance();
                number = i;
            }
        }
        return horses.get(number);
    }

    public void printWinner (){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}

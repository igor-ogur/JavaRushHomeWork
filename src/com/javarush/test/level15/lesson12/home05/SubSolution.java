package com.javarush.test.level15.lesson12.home05;

/**
 * Created by SKLAD-PC on 16.02.15.
 */
public class SubSolution extends Solution{
    public SubSolution() {
    }

    SubSolution(String name, String surname, int age, int weight, int id, String file, String car, int number) {
        super(name, surname, age, weight, id, file, car, number);
    }

    SubSolution(String name, String surname, int age, int weight, int id, String file, String car) {
        super(name, surname, age, weight, id, file, car);
    }

    SubSolution(String name, String surname, int age, int weight, int id, String file) {
        super(name, surname, age, weight, id, file);
    }

    protected SubSolution(String name, String surname, int age, int weight, int id) {
        super(name, surname, age, weight, id);
    }

    protected SubSolution(String name, String surname, int age, int weight) {
        super(name, surname, age, weight);
    }

    protected SubSolution(String name, String surname, int age) {
        super(name, surname, age);
    }

    public SubSolution(String name, String surname) {
        super(name, surname);
    }

    public SubSolution(String name) {
        super(name);
    }

    private SubSolution(String name, String surname, int age, int weight, int id, String file, String car, int number, int code) {
    }

    private SubSolution(String name, String surname, int age, int weight, int id, String file, String car, int number, int code, String male) {
    }

    private SubSolution(String name, String surname, int age, int weight, int id, String file, String car, int number, int code, String male, String adress) {
    }
}

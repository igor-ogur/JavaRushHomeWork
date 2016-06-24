package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution() {
    }

    public Solution(String name) {
    }

    public Solution(String name, String surname) {
    }

    protected Solution(String name, String surname, int age) {
    }

    protected Solution(String name, String surname, int age, int weight) {
    }

    protected Solution(String name, String surname, int age, int weight, int id) {
    }

    Solution(String name, String surname, int age, int weight, int id, String file) {
    }

    Solution(String name, String surname, int age, int weight, int id, String file, String car) {
    }

    Solution(String name, String surname, int age, int weight, int id, String file, String car, int number) {
    }

    private Solution(String name, String surname, int age, int weight, int id, String file, String car, int number, int code) {
    }

    private Solution(String name, String surname, int age, int weight, int id, String file, String car, int number, int code, String male) {
    }

    private Solution(String name, String surname, int age, int weight, int id, String file, String car, int number, int code, String male, String adress) {
    }






}


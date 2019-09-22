package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private String name;
        private boolean isMale;
        private String address;
        private int height;
        private int weight;

        public Human(int age, String name, boolean isMale, int height, int weight) {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
            this.height = height;
            this.weight = weight;
        }

        public Human(int age, String name, boolean isMale, String address, int height) {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
            this.address = address;
            this.height = height;
        }

        public Human(int age, String name, boolean isMale, String address) {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
            this.address = address;
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Human(int age, String name, boolean isMale) {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
        }

        public Human(boolean isMale) {
            this.isMale = isMale;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(int age, String name, boolean isMale, String address, int height, int weight) {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
            this.address = address;
            this.height = height;
            this.weight = weight;
        }

        public Human() {
        }
        // Напишите тут ваши переменные и конструкторы
    }
}
/*Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.*/
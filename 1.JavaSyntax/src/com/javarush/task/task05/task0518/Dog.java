package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
*/


public class Dog {
    private String name, color;
    private int height;

    public Dog(String name, int height, String color) {
        this.name = name;
        this.color = color;
        this.height = height;
    }

    public Dog(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public Dog(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
/*Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет


Требования:
1. У класса Dog должна быть переменная name с типом String.
2. У класса Dog должна быть переменная height с типом int.
3. У класса Dog должна быть переменная color с типом String.
4. У класса должен быть конструктор, принимающий в качестве параметра имя и инициализирующий соответствующую переменную класса.
5. У класса должен быть конструктор, принимающий в качестве параметров имя, рост и инициализирующий соответствующие переменные класса.
6. У класса должен быть конструктор, принимающий в качестве параметров имя, рост, цвет и инициализирующий соответствующие переменные класса.*/
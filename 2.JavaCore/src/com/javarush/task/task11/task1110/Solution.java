package com.javarush.task.task11.task1110;

/* 
Не забываем инкапсулировать
*/

public class Solution {
    public static void main(String[] args) {
    }

    public class Cat {
        private String name;
        private int age, weight, speed;

        public Cat(String name, int age, int weight) {

        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setWeight(int weight) {
            this.weight= weight;
        }

        public void setSpeed(int speed) {
            this.speed=speed;
        }
    }
}
/*Не забываем инкапсулировать
Посмотри внимательно на методы и добавь недостающие поля.


Требования:
1. В классе Cat должно быть поле типа String с именем name.
2. В классе Cat должно быть поле типа int с именем age.
3. В классе Cat должно быть поле типа int с именем weight.
4. В классе Cat должно быть поле типа int с именем speed.
5. В классе Cat должны быть 4 поля.
6. Все поля класса Cat должны быть private.*/
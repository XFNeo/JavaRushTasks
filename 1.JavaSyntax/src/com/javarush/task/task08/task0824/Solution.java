package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("Child1", true, 2, new ArrayList<>());
        Human child2 = new Human("Child2", false, 4, new ArrayList<>());
        Human child3 = new Human("Child3", true, 6, new ArrayList<>());

        Human mother = new Human("Mother", false, 25, new ArrayList<>(Arrays.asList(child1, child2, child3)));
        Human father = new Human("Father", true, 25, new ArrayList<>(Arrays.asList(child1, child2, child3)));

        Human grandMother1 = new Human("grandMother1", false, 50, new ArrayList<>(Arrays.asList(mother)));
        Human grandFather1 = new Human("grandFather1", true, 50, new ArrayList<>(Arrays.asList(mother)));
        Human grandMother2 = new Human("grandMother2", false, 50, new ArrayList<>(Arrays.asList(father)));
        Human grandFather2 = new Human("grandFather2", true, 50, new ArrayList<>(Arrays.asList(father)));

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandMother1);
        System.out.println(grandFather1);
        System.out.println(grandMother2);
        System.out.println(grandFather2);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
/*Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.*/

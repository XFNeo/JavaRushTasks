package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.annotation.*;


import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public List<Animal> animals = new ArrayList<>();
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes({})
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }
    @JsonTypeName("dog")
    public static class Dog extends Animal {

        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }
    @JsonTypeName("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}
/*{"animals":[{"name":"doggy","barkVolume":0.0},{"name":"catty","lives":0}]}

Должно стать:
{"animals":[{"type":"dog","name":"doggy","barkVolume":0.0},{"type":"cat","name":"catty","lives":0}]}
{"animals":[{"type":"dog","name":"doggy","barkVolume":0.0},{"type":"cat","name":"catty","lives":0}]}

Требования:
1. Класс Zoo.Animal должен быть отмечен аннотацией @JsonTypeInfo.
2. Класс Zoo.Animal должен быть отмечен аннотацией @JsonSubTypes.
3. Класс Zoo.Dog должен быть отмечен аннотацией @JsonTypeName.
4. Класс Zoo.Cat должен быть отмечен аннотацией @JsonTypeName.
5. При сериализации в JSON всем объектам списка animals должен быть добавлен тип и сохранен основной формат (пример в задании).*/
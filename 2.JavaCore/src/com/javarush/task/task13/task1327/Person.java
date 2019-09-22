package com.javarush.task.task13.task1327;

public class Person implements RepkaItem{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePadezh() {
        return namePadezh;
    }

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }

    public void pull(Person person){
        System.out.println(name + " за " + person.namePadezh);
    }
}
/*Репка
Сказка Репка:
1. Реализовать интерфейс RepkaItem в классе Person.
2. В классе Person реализовать метод pull(Person person), который выводит фразу типа '<name> за <person>'.

Пример:
Бабка за Дедку
Дедка за Репку

3. Исправить логическую ошибку цикла в методе tell класса RepkaStory.
4. Выполнить метод main и наслаждаться сказкой!


Требования:
1. Интерфейс RepkaItem должен быть реализован в классе Person.
2. В классе Person должен быть реализован метод pull c одним параметром типа Person.
3. Метод pull в классе Person должен выводить на экран фразу типа '<name> за <person>'. Например: Бабка за Дедку.
4. В результате выполнения метода main на экран должен быть выведен краткий вариант сказки про Репку.*/
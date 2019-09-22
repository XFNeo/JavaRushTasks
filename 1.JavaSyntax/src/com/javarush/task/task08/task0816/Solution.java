package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне1", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("FEBRUARY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("MARCH 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("APRIL 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне10", dateFormat.parse("SEPTEMBER 1 2012"));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        map.entrySet().removeIf(entry -> entry.getValue().getMonth() >= 5 && entry.getValue().getMonth() < 8);
    }

    public static void main(String[] args) {

    }
}
/*Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.*/
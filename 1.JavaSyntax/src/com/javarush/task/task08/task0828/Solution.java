package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        Map<String,Integer> map = new HashMap<>();
        map.put("january",1);
        map.put("february",2);
        map.put("march",3);
        map.put("april",4);
        map.put("may",5);
        map.put("june",6);
        map.put("july",7);
        map.put("august",8);
        map.put("september",9);
        map.put("october",10);
        map.put("november",11);
        map.put("december",12);

        System.out.println(month + " is the " + map.get(month.toLowerCase()) +" month");


    }
}
/*Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
Используйте коллекции.


Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.*/
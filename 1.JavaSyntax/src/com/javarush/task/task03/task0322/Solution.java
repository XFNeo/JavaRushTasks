package com.javarush.task.task03.task0322;

/* 
Большая и чистая
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        System.out.println(s1 + " + " + s2 + " + " + s3 + " = Чистая любовь, да-да!");

    }
}
/*Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!

Пример:
Вася + Ева + Анжелика = Чистая любовь, да-да!


Требования:
1. Программа должна выводить текст.
2. Программа должна считывать данные с клавиатуры.
3. Выведенный текст должен содержать введенное имя name1.
4. Выведенный текст должен содержать введенное имя name2.
5. Выведенный текст должен содержать введенное имя name3.
6. Выведенный тест должен полностью соответствовать заданию.*/
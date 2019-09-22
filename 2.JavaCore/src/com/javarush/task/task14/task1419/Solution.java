package com.javarush.task.task14.task1419;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] arr = new int[1];
            arr[2] = 2;
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.get(50);
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            Integer i = Integer.parseInt("dsa");
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            String s = null;
            s.length();
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            FileReader reader = new FileReader("d:\\1232132");
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            String s = "";
            s.charAt(3);
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            int[] arr = new int[-1];
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        }catch (Exception e){
            exceptions.add(e);
        }
        try {
            String[] strs = {"dsad","dsa"};
            List<String> list = Arrays.asList(strs);
            list.remove("dsad");
        }catch (Exception e){
            exceptions.add(e);
        }
        //напишите тут ваш код

    }
}
/*Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.*/
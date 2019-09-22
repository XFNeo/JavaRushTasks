package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int sum = 0;
        for (int i = 0; i <3; i++) {
            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }
}
/*Сумма цифр трехзначного числа
Напиши код метода sumDigitsInNumber(int number). Метод на вход принимает целое трехзначное число. Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.

Пример:
Метод sumDigitsInNumber вызывается с параметром 546.

Пример вывода:
15


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод sumDigitsInNumber(int) должен быть публичным и статическим.
3. Метод sumDigitsInNumber должен возвращать значение типа int.
4. Метод sumDigitsInNumber не должен ничего выводить на экран.
5. Метод sumDigitsInNumber должен правильно возвращать сумму всех цифр в числе number.*/
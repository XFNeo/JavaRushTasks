package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder result =  new StringBuilder();
        if (reader ==  null) return result.toString();
        int k;
        while ((k = reader.read()) != -1){
            result.append((char)(k + key));
        }
        return result.toString();
    }
}
/*Шифр Цезаря
Привет Амиго. Ты знаешь, за нами следят, просматривают нашу переписку. Поэтому нужно шифровать трафик.
Для тебя не составит труда реализовать шифр Цезаря, напомню что это просто сдвиг вправо по алфавиту на key букв.
В методе main есть хороший пример.

Реализуй логику метода String decode(StringReader reader, int key).
Метод получает данные в закодированном виде.
Он должен вернуть дешифрованную строку, что хранится в StringReader - е.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.


Требования:
1. Класс Solution должен содержать метод String decode(StringReader reader, int key).
2. Метод decode(StringReader reader, int key) должен вернуть дешифрованную строку что хранится в StringReader - е.
3. Возвращаемый объект ни при каких условиях не должен быть null.*/
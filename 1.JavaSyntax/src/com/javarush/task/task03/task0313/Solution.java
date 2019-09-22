package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        String s1 = "Мама";
        String s2 = "Мыла";
        String s3 = "Раму";

        System.out.println(s1+s2+s3);
        System.out.println(s1+s3+s2);
        System.out.println(s2+s1+s3);
        System.out.println(s2+s3+s1);
        System.out.println(s3+s2+s1);
        System.out.println(s3+s1+s2);

    }
}
/*Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".

Подсказка: их 6 штук.
Каждую комбинацию вывести с новой строки. Слова не разделять.

Пример:
МылаРамуМама
РамуМамаМыла
...


Требования:
1. Программа должна выводить текст.
2. Выведенный текст должен содержать 6 строк.
3. Текст в каждой строке должен быть уникален.
4. Должны быть выведены все возможные комбинации.*/
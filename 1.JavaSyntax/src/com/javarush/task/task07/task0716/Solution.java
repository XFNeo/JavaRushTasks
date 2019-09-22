package com.javarush.task.task07.task0716;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            boolean hasL = false;
            boolean hasR = false;
            for (int j = 0; j < strings.get(i).length(); j++) {
                if (strings.get(i).charAt(j) == 'р') {
                    hasR = true;
                }
                if (strings.get(i).charAt(j) == 'л') {
                    hasL = true;
                }
            }
            if (!(hasR && hasL)) {
                if (hasL) {
                    list.add(strings.get(i));
                    list.add(strings.get(i));
                } else {
                    if (!hasR) list.add(strings.get(i));
                }
            } else {
                list.add(strings.get(i));
            }
        }
        return list;
    }
}
/*Р или Л
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву "р"
2.2. удваивать все слова содержащие букву "л".
2.3. если слово содержит и букву "р" и букву "л", то оставить это слово без изменений.
2.4. с другими словами ничего не делать.

Пример:
роза
лира
лоза

Выходные данные:
лира
лоза
лоза


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод fix должен удалять из списка строк все слова, содержащие букву "р". Исключение: слова содержащие и букву "р" и букву "л" - их нужно оставить.
3. Метод fix должен удваивать слова, содержащие букву "л" (добавлять еще один элемент с этим словом). Исключение: слова содержащие и букву "л" и букву "р" - их не нужно удваивать.
4. Метод fix не должен ничего делать со словами, содержащими и букву "л" и букву "р".
5. Метод fix не должен ничего делать со словами, которые не содержат ни букву "л", ни букву "р".*/
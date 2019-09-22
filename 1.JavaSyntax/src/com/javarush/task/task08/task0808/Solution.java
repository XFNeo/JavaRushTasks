package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main(String[] args) {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(list.size()/2, new Object());
        }

    }

    public static void get10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.get(list.size()/2);
        }


    }

    public static void set10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.set(list.size()/2, new Object());
        }


    }

    public static void remove10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.remove(list.size()/2);
        }


    }
}
/*10 тысяч удалений и вставок
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только 5 методов.
4. Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
5. Метод get10000(List list) должен вызывать 10 тысяч раз get у списка.
6. Метод set10000(List list) должен вызывать 10 тысяч раз set у списка.
7. Метод remove10000(List list) должен удалять 10 тысяч элементов из списка.*/
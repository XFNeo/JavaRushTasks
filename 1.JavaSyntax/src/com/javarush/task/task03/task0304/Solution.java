package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        return i +(i*0.1);

    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
/*Задача на проценты
Напиши код метода addTenPercent, который увеличивает переданное целое число на 10%.
Для возврата результата из метода addTenPercent используй оператор return.

Пример:
return 123 * 435;


Требования:
1. Метод addTenPercent должен увеличивать переданное число на 10% процентов.
2. Метод main должен вызывать метод addTenPercent.
3. Метод main должен выводить результаты вызова на экран.
4. Метод addTenPercent не должен ничего выводить на экран.*/
package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();

        Class<?> resultClass = Arrays.stream(classes)
                .filter(c-> List.class.isAssignableFrom(c) && Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers()))
                .filter(c-> {
                    try {
                        c.getDeclaredMethod("get", int.class);
                        Constructor<?> declaredConstructor = c.getDeclaredConstructor();
                        declaredConstructor.setAccessible(true);
                        List list = (List) declaredConstructor.newInstance();
                        list.get(1);
                        return false;
                    } catch (IndexOutOfBoundsException e){
                        return true;
                    } catch (NoSuchMethodException e) {
                        return false;
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .findFirst().orElse(null);
        return resultClass;
    }
}
/*Описание класса:
1. Реализует интерфейс List;
2. Является приватным статическим классом внутри популярного утилитного класса;
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.


Требования:
1.	Метод getExpectedClass должен использовать метод getDeclaredClasses подходящего утилитного класса.
2.	Метод getExpectedClass должен вернуть правильный тип.
3.	Метод main должен вызывать метод getExpectedClass.
4.	Метод main должен вывести полученный класс на экран.*/
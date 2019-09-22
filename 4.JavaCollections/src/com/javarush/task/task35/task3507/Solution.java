package com.javarush.task.task35.task3507;

import com.sun.org.apache.bcel.internal.generic.Type;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Set<? extends Animal> allAnimals = getAllAnimals(
                Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                        Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws IOException, ClassNotFoundException {
        Set<Animal> set = new HashSet<>();
        MyClassLoader loader = new MyClassLoader();
        File[] files = new File(pathToAnimals).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                Class<?> loadedClass = loader.load(file.toPath());
                if (Animal.class.isAssignableFrom(loadedClass)) {
                    try {
                        loadedClass.getConstructor();
                        set.add((Animal) loadedClass.newInstance());
                    } catch (NoSuchMethodException e) {

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return set;
    }
}
/*Реализуй логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.


Требования:
1.	Размер множества возвращаемого методом getAllAnimals должен быть равен количеству классов поддерживающих интерфейс Animal
и имеющих публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).

2.	В множестве возвращаемом методом getAllAnimals должны присутствовать все классы поддерживающие интерфейс Animal
и имеющие публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).

3.	В множестве возвращаемом методом getAllAnimals НЕ должен присутствовать ни один класс не поддерживающий интерфейс Animal
 или не имеющий публичного конструктора без параметров (среди классов расположенных в директории переданной в качестве параметра).

4.	Метод getAllAnimals должен быть статическим.*/
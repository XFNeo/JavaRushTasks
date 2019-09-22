package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if (args.length != 1) return;
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            String[] line = reader.readLine().split(" ");
            int year = Integer.parseInt(line[line.length-1]);
            int month = Integer.parseInt(line[line.length-2]);
            int day = Integer.parseInt(line[line.length-3]);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length - 3; i++) {
                if (i == line.length - 4){
                    sb.append(line[i]);
                } else {
                    sb.append(line[i]).append(" ");
                }
            }
            Date date = new Date(year-1900,month-1,day);
            PEOPLE.add(new Person(sb.toString(),date));
        }
        reader.close();
    }
}
/*Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.*/
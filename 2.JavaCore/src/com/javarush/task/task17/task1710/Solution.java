package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                System.out.println(create(args[1], args[2], args[3]));
                break;
            case "-u":
                update(Integer.parseInt(args[1]), args[2], args[3], args[4]);
                break;
            case "-d":
                delete(Integer.parseInt(args[1]));
                break;
            case "-i":
                System.out.println(info(Integer.parseInt(args[1])));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + args[0]);
        }
    }

    public static int create(String name, String sex, String bd) {
        Date date = new Date();
        date.setDate(Integer.parseInt(bd.split("/")[0]));
        date.setMonth(Integer.parseInt(bd.split("/")[1]) - 1);
        date.setYear(Integer.parseInt(bd.split("/")[2]) - 1900);
        allPeople.add(sex.equalsIgnoreCase("м") ? Person.createMale(name, date) : Person.createFemale(name, date));
        return allPeople.size() - 1;
    }

    public static void update(int id, String name, String sex, String bd) {
        Person toUpd = allPeople.get(id);
        Date date = new Date();
        date.setDate(Integer.parseInt(bd.split("/")[0]));
        date.setMonth(Integer.parseInt(bd.split("/")[1]) - 1);
        date.setYear(Integer.parseInt(bd.split("/")[2]) - 1900);
        toUpd.setBirthDate(date);
        toUpd.setName(name);
        toUpd.setSex(sex.equalsIgnoreCase("м") ? Sex.MALE : Sex.FEMALE);
    }

    public static void delete(int id) {
        Person toDel = allPeople.get(id);
        toDel.setBirthDate(null);
        toDel.setName(null);
        toDel.setSex(null);
    }

    public static String info(int id) {
        SimpleDateFormat ff = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        Person person = allPeople.get(id);
        return person.getName() + (person.getSex().equals(Sex.MALE) ? " м " : " ж ") + ff.format(person.getBirthDate());
    }
}
/*CRUD
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.*/
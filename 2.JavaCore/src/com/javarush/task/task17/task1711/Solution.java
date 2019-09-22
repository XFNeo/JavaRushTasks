package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    System.out.println(create(args));
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    update(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    delete(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    System.out.println(info(args));
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + args[0]);
        }
    }

    public static String create(String[] args) {
        int count = 0;
        for (int i = 1; i < args.length; i += 3) {
            Date date = new Date();
            date.setDate(Integer.parseInt(args[i + 2].split("/")[0]));
            date.setMonth(Integer.parseInt(args[i + 2].split("/")[1]) - 1);
            date.setYear(Integer.parseInt(args[i + 2].split("/")[2]) - 1900);
            Person toAdd = args[i + 1].equalsIgnoreCase("м") ? Person.createMale(args[i], date) : Person.createFemale(args[i], date);
            synchronized (allPeople) {
                allPeople.add(toAdd);
            }
            count++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = count; i > 0; i--) {
            str.append(allPeople.size() - i).append("\n");
        }

        return str.toString();
    }

    public static void update(String[] args) {
        synchronized (allPeople) {
            for (int i = 1; i < args.length; i += 4) {
                Person toUpd = allPeople.get(Integer.parseInt(args[i]));
                Date date = new Date();
                date.setDate(Integer.parseInt(args[i + 3].split("/")[0]));
                date.setMonth(Integer.parseInt(args[i + 3].split("/")[1]) - 1);
                date.setYear(Integer.parseInt(args[i + 3].split("/")[2]) - 1900);
                toUpd.setBirthDate(date);
                toUpd.setName(args[i + 1]);
                toUpd.setSex(args[i + 2].equalsIgnoreCase("м") ? Sex.MALE : Sex.FEMALE);
            }
        }

    }

    public static void delete(String[] args) {
        synchronized (allPeople) {
            for (int i = 1; i < args.length; i++) {
                Person toDel = allPeople.get(Integer.parseInt(args[i]));
                toDel.setBirthDate(null);
                toDel.setName(null);
                toDel.setSex(null);
            }
        }


    }

    public static String info(String[] args) {
        synchronized (allPeople) {
            StringBuilder str = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                SimpleDateFormat ff = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
                Person person = allPeople.get(Integer.parseInt(args[i]));
                str.append(person.getName()).append(person.getSex().equals(Sex.MALE) ? " м " : " ж ").append(ff.format(person.getBirthDate())).append("\n");
            }
            return str.toString();
        }
    }
}

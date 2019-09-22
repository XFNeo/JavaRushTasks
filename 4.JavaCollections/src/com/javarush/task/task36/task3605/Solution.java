package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Set<Character> set = new TreeSet<>();
        while (reader.ready()){
            String line = reader.readLine().replaceAll("\\W", "").toLowerCase();
            List<Character> list = line.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            set.addAll(list);
        }
        set.stream().limit(5).forEach(System.out::print);
    }
}
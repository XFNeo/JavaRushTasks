package com.javarush.task.task19.task1910;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class asd {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("dog");
        Matcher m = p.matcher("1dogddasd");
        System.out.println(m.lookingAt());
    }
}
